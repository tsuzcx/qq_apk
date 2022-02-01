package com.tencent.biz.qqcircle;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.beans.FeedVideoCoverBean;
import com.tencent.biz.qqcircle.datacenter.rank.QCircleRankEdgeConfig;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.immersive.part.QFSMessageNoticePart;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QCirclePluginGlobalInfo
{
  public static ConcurrentHashMap<Integer, Boolean> a = new ConcurrentHashMap();
  public static String b;
  private static HashMap<String, FeedCloudMeta.StFeed> c = new HashMap();
  private static HashMap<String, Integer> d = new HashMap();
  private static int e = QCircleConfigHelper.a(6);
  private static final AtomicInteger f = new AtomicInteger(0);
  private static int g = -1;
  private static String h = "";
  private static MockLbsInfo i = null;
  private static volatile WeakReference<FeedVideoCoverBean> j;
  private static boolean k;
  private static QCircleRankEdgeConfig l;
  
  public static Drawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return QCircleApplication.APP.getResources().getDrawable(2130845204);
    }
    Bitmap localBitmap = HostFaceUtils.getBitmapFromCache(HostFaceUtils.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true));
    if (localBitmap != null) {
      return new BitmapDrawable(localBitmap);
    }
    return HostFaceUtils.getFaceDrawable(1, 4, paramString);
  }
  
  public static void a()
  {
    try
    {
      QCircleFollowManager.getInstance().clearAll();
      QCircleTagFollowManager.a().b();
      QCirclePushInfoManager.a().b();
      QCirclePluginConfig.d();
      a(true);
      g = -1;
      HostDataTransUtils.release();
      QCircleDrawableCacheUtils.a();
      b(false);
      QCircleSwitchConfigManager.a().c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt)
  {
    e = paramInt;
  }
  
  public static void a(QCircleRankEdgeConfig paramQCircleRankEdgeConfig)
  {
    l = paramQCircleRankEdgeConfig;
  }
  
  public static void a(MockLbsInfo paramMockLbsInfo)
  {
    i = paramMockLbsInfo;
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if (j != null)
    {
      j.clear();
      j = null;
    }
    FeedVideoCoverBean localFeedVideoCoverBean = new FeedVideoCoverBean();
    localFeedVideoCoverBean.a(paramString, paramBitmap);
    j = new WeakReference(localFeedVideoCoverBean);
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStFeed != null)) {
      c.put(paramString, paramStFeed);
    }
  }
  
  public static void a(String paramString, Integer paramInteger)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qcircle_fakeid_"))) {
      d.put(paramString, paramInteger);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if ((f.get() == 0) || (paramBoolean))
      {
        d.clear();
        QCirclePolyLikePopWindow.b();
        QCircleFeedPicLoader.g().release();
        QCircleRichMediaDownLoadManager.a().b();
        QCircleDrawableCacheUtils.a();
        a.clear();
      }
      if (j != null)
      {
        j.clear();
        j = null;
      }
      if (QCircleConfigHelper.bg()) {
        QFSMessageNoticePart.n();
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(Integer paramInteger)
  {
    a.put(paramInteger, Boolean.valueOf(true));
    return true;
  }
  
  public static int b()
  {
    return e;
  }
  
  public static FeedCloudMeta.StFeed b(String paramString)
  {
    return (FeedCloudMeta.StFeed)c.get(paramString);
  }
  
  public static Boolean b(Integer paramInteger)
  {
    if (!a.containsKey(paramInteger)) {
      return Boolean.valueOf(false);
    }
    return (Boolean)a.get(paramInteger);
  }
  
  public static void b(int paramInt)
  {
    g = paramInt;
  }
  
  public static void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsFirstLogin  sIsFirstLogin = ");
    localStringBuilder.append(k());
    localStringBuilder.append(" , isFirstLogin = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("QCircleGlobalInfo", 1, localStringBuilder.toString());
    k = paramBoolean;
  }
  
  public static FeedCloudMeta.StUser c()
  {
    return d();
  }
  
  public static boolean c(String paramString)
  {
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((FeedCloudMeta.StFeed)c.get(str)).id.get().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static FeedCloudMeta.StUser d()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(HostDataTransUtils.getAccount());
    localStUser.nick.set(HostDataTransUtils.getAccountNickName(HostDataTransUtils.getAccount()));
    return localStUser;
  }
  
  public static Integer d(String paramString)
  {
    if (d.containsKey(paramString)) {
      return (Integer)d.get(paramString);
    }
    return Integer.valueOf(-1);
  }
  
  public static String e()
  {
    return HostDataTransUtils.getAccount();
  }
  
  public static void e(String paramString)
  {
    h = paramString;
  }
  
  public static Bitmap f(String paramString)
  {
    if ((j != null) && (j.get() != null)) {
      return ((FeedVideoCoverBean)j.get()).a(paramString);
    }
    return null;
  }
  
  public static void f()
  {
    int m = f.incrementAndGet();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enter a page currentPageCount:");
    localStringBuilder.append(m);
    QLog.d("QCircleGlobalInfo", 1, localStringBuilder.toString());
  }
  
  public static void g()
  {
    int m = f.decrementAndGet();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exit a page currentPageCount:");
    localStringBuilder.append(m);
    QLog.d("QCircleGlobalInfo", 1, localStringBuilder.toString());
  }
  
  public static int h()
  {
    return g;
  }
  
  public static String i()
  {
    return h;
  }
  
  public static MockLbsInfo j()
  {
    return i;
  }
  
  public static boolean k()
  {
    return k;
  }
  
  public static String l()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    b = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getPluginQUA();
    return b;
  }
  
  public static String m()
  {
    return ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getPluginMark();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePluginGlobalInfo
 * JD-Core Version:    0.7.0.1
 */