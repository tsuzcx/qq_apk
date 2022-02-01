package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.LBSDetetor;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.LBSDetetor.LBSTemplateListener;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  private static LbsFilterStatusManager i;
  private boolean a = true;
  private Handler b;
  private AppInterface c;
  private PtvTemplateInfo d;
  private LbsFilterStatusManager.LbsUpdateFilter e;
  private SparseArray<LbsFilterStatusManager.LbsRequestStatus> f = new SparseArray(1);
  private int g = 2;
  private boolean h = false;
  private INetInfoHandler j = new LbsFilterStatusManager.3(this);
  
  private LbsFilterStatusManager(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      this.c = paramAppInterface;
      this.b = ThreadManager.getUIHandlerV2();
      this.f.put(1, LbsFilterStatusManager.LbsRequestStatus.a());
      AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.j);
      return;
    }
    throw new RuntimeException("new LbsFilterStatusManager app==null");
  }
  
  public static LbsFilterStatusManager a(AppInterface paramAppInterface)
  {
    try
    {
      if (i == null)
      {
        i = new LbsFilterStatusManager(paramAppInterface);
        LBSDetetor.a(paramAppInterface).a(i);
      }
      paramAppInterface = i;
      return paramAppInterface;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "LBS_FILTER_UNINIT_KIND";
        }
        return "LBS_FILTER_SPECIAL_KIND";
      }
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_LOADING_KIND";
  }
  
  private void a()
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.f.get(this.d.t);
    Object localObject = this.d;
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { ((PtvTemplateInfo)localObject).a(((PtvTemplateInfo)localObject).t) }), null);
    if (localLbsRequestStatus != null)
    {
      if (!this.a) {
        return;
      }
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localLbsRequestStatus.e() }), null);
      if (localLbsRequestStatus.e == 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(localLbsRequestStatus.d);
        a("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
        if (localLbsRequestStatus.d > 0L)
        {
          long l = System.currentTimeMillis() - localLbsRequestStatus.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(l);
          a("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
          if (l < 30000L)
          {
            bool = false;
            break label231;
          }
        }
        boolean bool = true;
        label231:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(bool);
        a("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
        if (bool)
        {
          localLbsRequestStatus.d();
          localLbsRequestStatus.c();
          localLbsRequestStatus.e = 1;
          localLbsRequestStatus.d = System.currentTimeMillis();
          LBSDetetor.a(this.c).a(this.d.t);
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        QLog.i("LbsFilterStatusManager", 2, localStringBuilder.toString(), paramThrowable);
        return;
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append(paramString1);
      paramThrowable.append("_");
      paramThrowable.append(paramString2);
      QLog.i("LbsFilterStatusManager", 2, paramThrowable.toString());
    }
  }
  
  private void b()
  {
    PtvTemplateInfo localPtvTemplateInfo = this.d;
    if (localPtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { localPtvTemplateInfo.a(localPtvTemplateInfo.t) }), null);
      if (!this.h) {
        a();
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.f.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.d.a(paramInt) }), null);
      if (localLbsRequestStatus.e != 3)
      {
        localLbsRequestStatus.b = paramBoolean;
        if (paramBoolean)
        {
          localLbsRequestStatus.e = 2;
          return;
        }
        localLbsRequestStatus.e = 3;
        c(paramInt);
        return;
      }
      a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localLbsRequestStatus.e() }), null);
      localLbsRequestStatus.b = paramBoolean;
      localLbsRequestStatus.c.clear();
      localLbsRequestStatus.a.c.clear();
      c(paramInt);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.f.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.d.a(paramInt) }), null);
      if (localLbsRequestStatus.e != 3)
      {
        if (paramBoolean)
        {
          localLbsRequestStatus.c.addAll(paramArrayList);
          a("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        localLbsRequestStatus.e = 3;
        c(paramInt);
        return;
      }
      a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localLbsRequestStatus.e() }), null);
    }
  }
  
  private boolean b(int paramInt)
  {
    return this.f.get(paramInt) != null;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.d.a(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.d.e, localObject }), null);
    if ((this.d.g) && (b(this.d.t)) && (this.d.t == paramInt))
    {
      boolean bool = d(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(bool);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
      if ((this.e != null) && (bool))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshed filterName=");
        ((StringBuilder)localObject).append(this.d.e);
        a("sendLoadingFilterMsg", ((StringBuilder)localObject).toString(), null);
        this.e.a(this.d.e);
      }
    }
  }
  
  private boolean d(int paramInt)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.f.get(paramInt);
    if ((localLbsRequestStatus.b) && (localLbsRequestStatus.a(this.d.a))) {
      paramInt = 3;
    } else {
      paramInt = 2;
    }
    a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.g) }), null);
    return paramInt != this.g;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.b.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.b.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */