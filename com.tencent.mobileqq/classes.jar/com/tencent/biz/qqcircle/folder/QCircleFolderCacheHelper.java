package com.tencent.biz.qqcircle.folder;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabViewModel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleFolderCacheHelper
{
  private static volatile QCircleFolderCacheHelper d;
  private final ConcurrentHashMap<String, QCircleFolderCacheHelper.QCircleFolderPageCache> a = new ConcurrentHashMap();
  private final long b = QCircleConfigHelper.o() * 1000;
  private final boolean c = QCircleConfigHelper.m();
  private int e = QCirclePluginGlobalInfo.b();
  private long f = 0L;
  private long g = System.currentTimeMillis();
  
  public static QCircleFolderCacheHelper a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new QCircleFolderCacheHelper();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static void b()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "releaseInstance");
    if (d != null) {
      try
      {
        if (d != null) {
          d = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private boolean h()
  {
    return System.currentTimeMillis() - this.g > this.b;
  }
  
  private void i()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "clearPageCache");
    this.a.clear();
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache() disable tab info cache,direct return!");
      return;
    }
    if (h())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache fail,idle over alive time,clean cache!");
      this.f = 0L;
      return;
    }
    this.e = paramInt;
    this.f = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveTabInfoCache currentShowTabType:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
  }
  
  public void a(@NonNull QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel, int paramInt1, int paramInt2)
  {
    if (!this.c)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "savePageCache fail,disable page cache,direct return!");
      return;
    }
    if (h())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "savePageCache fail,idle over alive time,clean cache!");
      this.f = 0L;
      i();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePageCache,pos:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",top:");
    localStringBuilder.append(paramInt2);
    QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
    if (b(paramQCircleAbsTabFeedViewModel, paramInt1, paramInt2))
    {
      this.f = System.currentTimeMillis();
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache failed!");
    this.f = 0L;
    i();
  }
  
  public boolean a(@NonNull QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "readPageCache");
    if (e())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,checkCacheAlive cache not alive");
      return false;
    }
    if (d())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null");
      return false;
    }
    if (b(paramQCircleAbsTabFeedViewModel)) {
      return true;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null or init error");
    return false;
  }
  
  public boolean a(@NonNull QCircleTabViewModel paramQCircleTabViewModel)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache");
    c();
    if (f())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache fail,checkCacheAlive cache not alive");
      i();
      return false;
    }
    if (paramQCircleTabViewModel.a(this.e))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache success");
      return true;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache fail,model is null or init error");
    return false;
  }
  
  boolean b(@NonNull QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel)
  {
    Object localObject = paramQCircleAbsTabFeedViewModel.b();
    if (localObject != null)
    {
      localObject = ((QQCircleFeedBase.StTabInfo)localObject).tabName.get();
      if (this.a.containsKey(localObject))
      {
        QCircleFolderCacheHelper.QCircleFolderPageCache localQCircleFolderPageCache = (QCircleFolderCacheHelper.QCircleFolderPageCache)this.a.get(localObject);
        if (localQCircleFolderPageCache != null)
        {
          paramQCircleAbsTabFeedViewModel.a(localQCircleFolderPageCache);
          if (paramQCircleAbsTabFeedViewModel.b(localQCircleFolderPageCache))
          {
            paramQCircleAbsTabFeedViewModel = new StringBuilder();
            paramQCircleAbsTabFeedViewModel.append("readPageCache success！tapid:");
            paramQCircleAbsTabFeedViewModel.append((String)localObject);
            paramQCircleAbsTabFeedViewModel.append(",pos:");
            paramQCircleAbsTabFeedViewModel.append(QCircleFolderCacheHelper.QCircleFolderPageCache.b(localQCircleFolderPageCache));
            paramQCircleAbsTabFeedViewModel.append(",top:");
            paramQCircleAbsTabFeedViewModel.append(QCircleFolderCacheHelper.QCircleFolderPageCache.c(localQCircleFolderPageCache));
            QLog.d("QCircleFolderCacheHelper", 1, paramQCircleAbsTabFeedViewModel.toString());
            return true;
          }
        }
      }
    }
    return false;
  }
  
  boolean b(@NonNull QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel, int paramInt1, int paramInt2)
  {
    Object localObject = QCircleFolderCacheHelper.QCircleFolderPageCache.a(paramQCircleAbsTabFeedViewModel, paramInt1, paramInt2);
    if (localObject != null)
    {
      paramQCircleAbsTabFeedViewModel = QCircleFolderCacheHelper.QCircleFolderPageCache.a((QCircleFolderCacheHelper.QCircleFolderPageCache)localObject).tabName.get();
      this.a.put(paramQCircleAbsTabFeedViewModel, localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("savePageCache success！tapid:");
      ((StringBuilder)localObject).append(paramQCircleAbsTabFeedViewModel);
      QLog.d("QCircleFolderCacheHelper", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    return false;
  }
  
  public void c()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "updateLastIdleTimeStamp");
    this.g = System.currentTimeMillis();
  }
  
  boolean d()
  {
    if (this.a.isEmpty())
    {
      i();
      return true;
    }
    return false;
  }
  
  boolean e()
  {
    if (f())
    {
      i();
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    int i;
    if ((this.c) && (l1 - l2 <= this.b)) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
  
  public void g()
  {
    i();
    this.f = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper
 * JD-Core Version:    0.7.0.1
 */