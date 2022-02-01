package com.tencent.biz.qqcircle.folder;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Collection;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleFolderCacheHelper$QCircleFolderPageCache
{
  private int a;
  private int b;
  private QQCircleFeedBase.StTabInfo c;
  private ArrayList<FeedCloudMeta.StFeed> d = null;
  private boolean e = false;
  private FeedCloudCommon.StCommonExt f = null;
  private String g = null;
  private String h = null;
  
  public static QCircleFolderPageCache a(QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel, int paramInt1, int paramInt2)
  {
    if (paramQCircleAbsTabFeedViewModel == null)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
      return null;
    }
    QCircleFolderPageCache localQCircleFolderPageCache = new QCircleFolderPageCache();
    QQCircleFeedBase.StTabInfo localStTabInfo = paramQCircleAbsTabFeedViewModel.b();
    Collection localCollection = paramQCircleAbsTabFeedViewModel.i();
    boolean bool = paramQCircleAbsTabFeedViewModel.j();
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleAbsTabFeedViewModel.k();
    String str = paramQCircleAbsTabFeedViewModel.e();
    paramQCircleAbsTabFeedViewModel = paramQCircleAbsTabFeedViewModel.f();
    if ((localStTabInfo != null) && (localCollection != null) && (!localCollection.isEmpty()) && (!TextUtils.isEmpty(str)))
    {
      localQCircleFolderPageCache.a = paramInt1;
      localQCircleFolderPageCache.b = paramInt2;
      localQCircleFolderPageCache.c = localStTabInfo;
      localQCircleFolderPageCache.d = new ArrayList();
      localQCircleFolderPageCache.d.addAll(localCollection);
      localQCircleFolderPageCache.e = bool;
      localQCircleFolderPageCache.f = localStCommonExt;
      localQCircleFolderPageCache.g = str;
      localQCircleFolderPageCache.h = paramQCircleAbsTabFeedViewModel;
      QLog.d("QCircleFolderCacheHelper", 1, "wrap success!");
      return localQCircleFolderPageCache;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public ArrayList<FeedCloudMeta.StFeed> c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public FeedCloudCommon.StCommonExt e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper.QCircleFolderPageCache
 * JD-Core Version:    0.7.0.1
 */