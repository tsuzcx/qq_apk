package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class CaptureSet
  extends CaptureComboBase
  implements CaptureComboDownloadListener
{
  public WeakReference<Activity> f;
  public ArrayList<CaptureComboBase> g = new ArrayList();
  public boolean h = false;
  float i = 1.0F;
  public long j = 0L;
  private final CopyOnWriteArraySet<CaptureComboBase> k = new CopyOnWriteArraySet();
  
  public CaptureSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    boolean bool = this instanceof ComboSet;
    Object localObject3;
    if (bool)
    {
      localObject1 = (ComboSet)this;
      if (CaptureComboFilter.a((ComboSet)localObject1, paramInt))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apply already");
          ((StringBuilder)localObject2).append(toString());
          QLog.i("QCombo", 2, ((StringBuilder)localObject2).toString());
        }
        VideoFilterTools.a().a((ComboSet)localObject1, paramActivity, paramInt);
        return 0;
      }
      localObject3 = (QIMFilterCategoryItem)this.e;
      if ((localObject3 != null) && (paramInt == 0))
      {
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ("back".equals(((QIMFilterCategoryItem)localObject3).i))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(CameraControl.b, 2);
          ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
        }
        else if (("front".equals(((QIMFilterCategoryItem)localObject3).i)) && (CameraAbility.d()))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(CameraControl.b, 1);
          ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
        }
      }
      localObject2 = VideoFilterTools.a().e[paramInt];
      if (localObject2 != null) {
        ((ComboSet)localObject2).b(paramActivity, paramInt);
      }
      VideoFilterTools.a().a((ComboSet)localObject1, paramActivity, paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apply ");
      ((StringBuilder)localObject1).append(toString());
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("QCombo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.g.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (CaptureComboBase)((Iterator)localObject2).next();
      if ((localObject3 instanceof CaptureComboFilter)) {
        ((List)localObject1).add(((CaptureComboFilter)localObject3).f);
      } else {
        ((CaptureComboBase)localObject3).a(paramActivity, paramInt);
      }
    }
    if (bool)
    {
      localObject2 = (CaptureComboManager)QIMManager.a(5);
      if (!localObject2.o[paramInt].a())
      {
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("apply ");
          paramActivity.append(toString());
          paramActivity.append(", ");
          paramActivity.append(paramInt);
          paramActivity.append(" comboApplyFilterAborted");
          QLog.i("QCombo", 2, paramActivity.toString());
        }
        return 0;
      }
      localObject2.o[paramInt].a(null);
      localObject3 = ((CaptureComboManager)localObject2).l;
      if (localObject3 != null)
      {
        localObject2 = ((CaptureComboManager)localObject2).a((ComboSet)this, ((VideoFilterTools.ComboFilterData)localObject3).a(paramInt).c);
        VideoFilterTools.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
        VideoFilterTools.a().a((QIMFilterCategoryItem)localObject2, paramInt);
        CaptureComboFilter.a(paramActivity, (List)localObject1, this, paramInt);
        if (((this.e instanceof QIMFilterCategoryItem)) && (((QIMFilterCategoryItem)this.e).c()) && (paramInt != 1) && (paramInt != 3)) {
          ((QimMusicPlayer)QIMManager.a().d(8)).a(paramInt);
        }
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this, paramInt);
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase)
  {
    if (QLog.isColorLevel())
    {
      paramCaptureComboBase = new StringBuilder();
      paramCaptureComboBase.append("onDownloadStart ");
      paramCaptureComboBase.append(toString());
      paramCaptureComboBase.append(", count=");
      paramCaptureComboBase.append(this.k.size());
      QLog.i("QCombo", 2, paramCaptureComboBase.toString());
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase, int paramInt)
  {
    this.h = true;
    this.k.remove(paramCaptureComboBase);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError ");
      localStringBuilder.append(toString());
      localStringBuilder.append(":");
      localStringBuilder.append(paramCaptureComboBase.toString());
      localStringBuilder.append(", count=");
      localStringBuilder.append(this.k.size());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (this.k.isEmpty())
    {
      b(2);
      a(paramInt);
    }
  }
  
  public void b()
  {
    super.b();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unApply ");
      ((StringBuilder)localObject).append(toString());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CaptureComboBase)((Iterator)localObject).next()).b(paramActivity, paramInt);
    }
  }
  
  public void b(CaptureComboBase paramCaptureComboBase)
  {
    this.k.remove(paramCaptureComboBase);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadSuccess= ");
      localStringBuilder.append(toString());
      localStringBuilder.append(":");
      localStringBuilder.append(paramCaptureComboBase.toString());
      localStringBuilder.append(", count=");
      localStringBuilder.append(this.k.size());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (this.k.isEmpty())
    {
      if (this.h)
      {
        b(2);
        a(4);
        return;
      }
      b(3);
      if (QLog.isColorLevel())
      {
        paramCaptureComboBase = new StringBuilder();
        paramCaptureComboBase.append("onDownloadFinish= ");
        paramCaptureComboBase.append(toString());
        paramCaptureComboBase.append(", count=");
        paramCaptureComboBase.append(this.k.size());
        QLog.i("QCombo", 2, paramCaptureComboBase.toString());
      }
      b();
    }
  }
  
  public int c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("getState = ");
      localStringBuilder.append(toString());
      localStringBuilder.append("  ");
    }
    else
    {
      localStringBuilder = null;
    }
    Iterator localIterator = this.g.iterator();
    int n;
    do
    {
      boolean bool = localIterator.hasNext();
      n = 0;
      if (!bool) {
        break;
      }
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
      m = localCaptureComboBase.c();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(m);
        localStringBuilder.append("|");
        localStringBuilder.append(localCaptureComboBase.toString());
        localStringBuilder.append("   ");
      }
      if (m == 2)
      {
        m = 0;
        n = 1;
        break label150;
      }
    } while (m != 1);
    int m = 1;
    break label150;
    m = 0;
    label150:
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (n != 0)
    {
      b(2);
      return 2;
    }
    if (m != 0)
    {
      if (this.b != 1) {
        d();
      }
      if (System.currentTimeMillis() - this.j > 60000L)
      {
        b(2);
        a(5);
        return 2;
      }
      return 1;
    }
    b(3);
    return 3;
  }
  
  public void c(CaptureComboBase paramCaptureComboBase)
  {
    this.g.add(paramCaptureComboBase);
    this.i = (1.0F / this.g.size());
  }
  
  public int d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download ");
      localStringBuilder.append(toString());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      a(6);
      return 2;
    }
    ThreadManager.getSubThreadHandler().post(new CaptureSet.1(this));
    return 1;
  }
  
  public float e()
  {
    try
    {
      Iterator localIterator = this.g.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
        f2 = localCaptureComboBase.e();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getProgress ");
          localStringBuilder.append(localCaptureComboBase.toString());
          localStringBuilder.append(" progress =");
          localStringBuilder.append(f2);
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        f3 = this.i;
      }
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public int g()
  {
    Object localObject = this.g.iterator();
    int n = 0;
    int m = 0;
    while (((Iterator)localObject).hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)((Iterator)localObject).next();
      StringBuilder localStringBuilder;
      if (localCaptureComboBase.c() == 2)
      {
        localCaptureComboBase.a(this);
        this.k.add(localCaptureComboBase);
        localCaptureComboBase.d();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download ");
          localStringBuilder.append(toString());
          localStringBuilder.append("  ");
          localStringBuilder.append(localCaptureComboBase.toString());
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        n = 1;
      }
      else if (localCaptureComboBase.c() == 1)
      {
        this.k.add(localCaptureComboBase);
        localCaptureComboBase.a(this);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloading ");
          localStringBuilder.append(toString());
          localStringBuilder.append(":");
          localStringBuilder.append(localCaptureComboBase.toString());
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        m = 1;
      }
    }
    this.j = System.currentTimeMillis();
    if (this.k.size() > 0)
    {
      b(1);
      a();
      localObject = (CaptureComboManager)QIMManager.b(5);
      if (localObject != null) {
        ((CaptureComboManager)localObject).b(this);
      }
    }
    if ((n == 0) && (m == 0))
    {
      b(3);
      b();
      return 3;
    }
    b(1);
    return 1;
  }
  
  public String h()
  {
    if (this.e != null) {
      return ((QIMFilterCategoryItem)this.e).a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet
 * JD-Core Version:    0.7.0.1
 */