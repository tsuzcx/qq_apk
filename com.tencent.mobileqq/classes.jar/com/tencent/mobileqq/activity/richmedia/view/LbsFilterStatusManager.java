package com.tencent.mobileqq.activity.richmedia.view;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSTemplateListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  public static AppInterface a;
  private boolean b;
  private long c;
  private Handler d;
  private AppInterface e;
  private PtvTemplateManager.PtvTemplateInfo f;
  private LbsFilterStatusManager.LbsUpdateFilter g;
  private SparseArray<LbsFilterStatusManager.LbsRequestStatus> h;
  private int i;
  private boolean j;
  
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
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.h.get(this.f.activityType);
    Object localObject = this.f;
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { ((PtvTemplateManager.PtvTemplateInfo)localObject).getLbsActivityType(((PtvTemplateManager.PtvTemplateInfo)localObject).activityType) }), null);
    if (localLbsRequestStatus != null)
    {
      if (!this.b) {
        return;
      }
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localLbsRequestStatus.c() }), null);
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
          localLbsRequestStatus.b();
          localLbsRequestStatus.a();
          localLbsRequestStatus.e = 1;
          localLbsRequestStatus.d = System.currentTimeMillis();
          LBSDetetor.a(this.e).a(this.f.activityType);
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
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = this.f;
    if (localPtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { localPtvTemplateInfo.getLbsActivityType(localPtvTemplateInfo.activityType) }), null);
      if (!this.j) {
        a();
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.h.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.f.getLbsActivityType(paramInt) }), null);
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
      a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localLbsRequestStatus.c() }), null);
      localLbsRequestStatus.b = paramBoolean;
      localLbsRequestStatus.c.clear();
      localLbsRequestStatus.a.c.clear();
      c(paramInt);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.h.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.f.getLbsActivityType(paramInt) }), null);
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
      a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localLbsRequestStatus.c() }), null);
    }
  }
  
  private boolean b(int paramInt)
  {
    return this.h.get(paramInt) != null;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.f.getLbsActivityType(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.f.name, localObject }), null);
    if ((this.f.usable) && (b(this.f.activityType)) && (this.f.activityType == paramInt))
    {
      boolean bool = d(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(bool);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
      if ((this.g != null) && (bool))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshed filterName=");
        ((StringBuilder)localObject).append(this.f.name);
        a("sendLoadingFilterMsg", ((StringBuilder)localObject).toString(), null);
        this.g.a(this.f.name);
      }
    }
  }
  
  private boolean d(int paramInt)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.h.get(paramInt);
    if ((localLbsRequestStatus.b) && (localLbsRequestStatus.a(this.f.id))) {
      paramInt = 3;
    } else {
      paramInt = 2;
    }
    a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.i) }), null);
    return paramInt != this.i;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    if (this.c == l)
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.d.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    long l = Thread.currentThread().getId();
    if (this.c == l)
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.d.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */