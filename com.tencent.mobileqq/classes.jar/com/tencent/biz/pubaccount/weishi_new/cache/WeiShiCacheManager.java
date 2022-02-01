package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFeed;
import UserGrowth.stGetTabsRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class WeiShiCacheManager
{
  private List<WSFriendItemData> jdField_a_of_type_JavaUtilList;
  private Map<String, Set<String>> jdField_a_of_type_JavaUtilMap;
  
  @NotNull
  private stSimpleGetFeedListRsp a()
  {
    WSLog.b("WeiShiCacheManager", "读取瀑布流缓存数据");
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp1.feeds = new ArrayList();
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = a(4);
    if ((localstSimpleGetFeedListRsp2 != null) && (localstSimpleGetFeedListRsp2.feeds != null)) {
      localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
    }
    localstSimpleGetFeedListRsp2 = a(1);
    if ((localstSimpleGetFeedListRsp2 != null) && (localstSimpleGetFeedListRsp2.feeds != null))
    {
      WSLog.b("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
      localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
    }
    return localstSimpleGetFeedListRsp1;
  }
  
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  private <T extends JceStruct> T a(T paramT, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = a();
    }
    while (TextUtils.isEmpty(str))
    {
      return null;
      if (paramInt == 2) {
        str = c();
      } else if (paramInt == 5) {
        str = d();
      } else if (paramInt == 3) {
        str = f();
      } else if (paramInt == 4) {
        str = b();
      } else if (paramInt == 6) {
        str = e();
      }
    }
    return WSFileUtils.a(paramT, str);
  }
  
  public static WeiShiCacheManager a()
  {
    return WeiShiCacheManager.SingletonHolder.a();
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
  }
  
  public static String a(int paramInt)
  {
    return WSSharePreferencesUtil.a("key_red_msg_valid_feed_id" + paramInt, "");
  }
  
  @NotNull
  private Set<String> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    return localObject;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    if ((localWeishiManager == null) || (paramstSimpleMetaFeed == null)) {
      WSLog.e("WeiShiCacheManager", "[onPause][handleCacheData] not the right feed, not save");
    }
    while (!localWeishiManager.a(paramstSimpleMetaFeed)) {
      return;
    }
    WSVideoPreloadManager.a(paramstSimpleMetaFeed);
  }
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    return WSFileUtils.a(paramJceStruct, paramString);
  }
  
  private boolean a(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return true;
    }
    int i = ((stSimpleMetaFeed)paramList.get(paramList.size() - 1)).hashCode();
    if (i == WSInitializeHelper.a().a())
    {
      WSLog.e("WeiShiCacheManager", "[onPause][handleCacheData] has been cached，not cache again");
      return true;
    }
    WSInitializeHelper.a().a(i);
    return false;
  }
  
  private int b()
  {
    return WSGlobalConfig.a().d();
  }
  
  private stSimpleGetFeedListRsp b()
  {
    Object localObject;
    if ((a(8)) && (a() >= 8))
    {
      WSLog.b("WeiShiCacheManager", "仅读取红点缓存");
      localObject = a(2);
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2;
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1;
    do
    {
      do
      {
        return localObject;
        WSLog.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
        localObject = a(2);
        localstSimpleGetFeedListRsp2 = a(1);
        localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
        localstSimpleGetFeedListRsp1.feeds = new ArrayList();
        if ((localObject != null) && (((stSimpleGetFeedListRsp)localObject).feeds != null))
        {
          WSLog.b("WeiShiCacheManager", "红点缓存数量 = " + ((stSimpleGetFeedListRsp)localObject).feeds.size());
          localstSimpleGetFeedListRsp1.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
        }
        localObject = localstSimpleGetFeedListRsp1;
      } while (localstSimpleGetFeedListRsp2 == null);
      localObject = localstSimpleGetFeedListRsp1;
    } while (localstSimpleGetFeedListRsp2.feeds == null);
    WSLog.b("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
    localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
    return localstSimpleGetFeedListRsp1;
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_vertical_data";
  }
  
  private String b(int paramInt)
  {
    if (paramInt == 13) {
      return d();
    }
    return c();
  }
  
  private int c()
  {
    return WSFeedDataManager.a().a;
  }
  
  private String c()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_falls_preload_feeds";
  }
  
  private String d()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_immersive_preload_feeds";
  }
  
  private String e()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_tabs_info_" + WeishiUtils.a();
  }
  
  private String f()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_data_" + WeishiUtils.a();
  }
  
  public int a()
  {
    return WSSharePreferencesUtil.a("key_red_msg_valid_count", 0);
  }
  
  public List<WSFriendItemData> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return Collections.emptyList();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Set<String> a()
  {
    return a(WeishiUtils.a());
  }
  
  public void a(int paramInt)
  {
    WSLog.e("WeiShiCacheManager", "[WeiShiCacheManager.java][clearRedDotPreloadCache] scene:" + paramInt);
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.12(this, paramInt));
  }
  
  public void a(stGetTabsRsp paramstGetTabsRsp)
  {
    if ((paramstGetTabsRsp == null) || (paramstGetTabsRsp.Tabs == null)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.13(this, paramstGetTabsRsp));
  }
  
  public void a(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.1(this, paramIWeiShiCacheCallback), 8, null, true);
  }
  
  public void a(String paramString)
  {
    a(WeishiUtils.a()).add(paramString);
  }
  
  public void a(List<stFeed> paramList)
  {
    if (c() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.4(this));
    }
    while (WSFeedUtils.a(paramList)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this, paramList));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (b() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this));
    }
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.7(this, new ArrayList(paramList), paramInt));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, long paramLong, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp.feeds = localArrayList;
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.11(this, localstSimpleGetFeedListRsp, paramInt, localArrayList, paramList, paramLong));
      return;
    }
    a(paramInt);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (a(paramList)) {
      return;
    }
    WSLog.e("WeiShiCacheManager", "[onPause][handleCacheData] to cache");
    a().a(paramList, paramInt);
    a(paramstSimpleMetaFeed);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    long l1 = WSSharePreferencesUtil.a("key_red_msg_valid_timestamp" + paramInt, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    WSLog.d("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + l1 + "-" + l2 + " = " + l3);
    return l3 > 0L;
  }
  
  public void b(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.2(this, paramIWeiShiCacheCallback), 8, null, true);
  }
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.9(this, paramList));
  }
  
  public void c(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.3(this, new WeakReference(paramIWeiShiCacheCallback)), 8, null, true);
  }
  
  public void c(List<WSFriendItemData> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void d(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.10(this, paramIWeiShiCacheCallback));
  }
  
  public void e(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.14(this, paramIWeiShiCacheCallback), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager
 * JD-Core Version:    0.7.0.1
 */