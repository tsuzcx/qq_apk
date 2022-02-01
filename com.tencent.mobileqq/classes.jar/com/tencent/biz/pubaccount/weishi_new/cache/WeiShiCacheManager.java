package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFeed;
import UserGrowth.stGetFollowedDramasRsp;
import UserGrowth.stGetTabsRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
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
  
  private stSimpleGetFeedListRsp a()
  {
    if ((a(8)) && (a() >= 8))
    {
      WSLog.b("WeiShiCacheManager", "仅读取红点缓存");
      return a(2);
    }
    WSLog.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
    Object localObject = a(2);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = a(1);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp2.feeds = new ArrayList();
    if ((localObject != null) && (((stSimpleGetFeedListRsp)localObject).feeds != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("红点缓存数量 = ");
      localStringBuilder.append(((stSimpleGetFeedListRsp)localObject).feeds.size());
      WSLog.b("WeiShiCacheManager", localStringBuilder.toString());
      localstSimpleGetFeedListRsp2.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
    }
    if ((localstSimpleGetFeedListRsp1 != null) && (localstSimpleGetFeedListRsp1.feeds != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("瀑布流缓存数量 = ");
      ((StringBuilder)localObject).append(localstSimpleGetFeedListRsp1.feeds.size());
      WSLog.b("WeiShiCacheManager", ((StringBuilder)localObject).toString());
      localstSimpleGetFeedListRsp2.feeds.addAll(localstSimpleGetFeedListRsp1.feeds);
    }
    return localstSimpleGetFeedListRsp2;
  }
  
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  @NotNull
  private stSimpleGetFeedListRsp a(boolean paramBoolean)
  {
    WSLog.b("WeiShiCacheManager", "读取瀑布流缓存数据");
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp1.feeds = new ArrayList();
    if (paramBoolean)
    {
      localstSimpleGetFeedListRsp2 = a(4);
      if ((localstSimpleGetFeedListRsp2 != null) && (localstSimpleGetFeedListRsp2.feeds != null)) {
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
      }
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = a(1);
    if ((localstSimpleGetFeedListRsp2 != null) && (localstSimpleGetFeedListRsp2.feeds != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("瀑布流缓存数量 = ");
      localStringBuilder.append(localstSimpleGetFeedListRsp2.feeds.size());
      WSLog.b("WeiShiCacheManager", localStringBuilder.toString());
      localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
    }
    return localstSimpleGetFeedListRsp1;
  }
  
  private <T extends JceStruct> T a(T paramT, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = a();
    } else if (paramInt == 2) {
      str = c();
    } else if (paramInt == 5) {
      str = d();
    } else if (paramInt == 3) {
      str = f();
    } else if (paramInt == 4) {
      str = b();
    } else if (paramInt == 6) {
      str = e();
    } else if (paramInt == 7) {
      str = g();
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return WSFileUtils.a(paramT, str);
  }
  
  public static WeiShiCacheManager a()
  {
    return WeiShiCacheManager.SingletonHolder.a();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_recommend_data");
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_feed_id");
    localStringBuilder.append(paramInt);
    return WSSharePreferencesUtil.a(localStringBuilder.toString(), "");
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
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    return WSFileUtils.a(paramJceStruct, paramString);
  }
  
  private boolean a(List<stSimpleMetaFeed> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
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
    return true;
  }
  
  private int b()
  {
    return WSGlobalConfig.a().d();
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_recommend_vertical_data");
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_falls_preload_feeds");
    return localStringBuilder.toString();
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_immersive_preload_feeds");
    return localStringBuilder.toString();
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_tabs_info_");
    localStringBuilder.append(WeishiUtils.a());
    return localStringBuilder.toString();
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_follow_data_");
    localStringBuilder.append(WeishiUtils.a());
    return localStringBuilder.toString();
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_follow_drama_data_");
    localStringBuilder.append(WeishiUtils.a());
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return WSSharePreferencesUtil.a("key_red_msg_valid_count", 0);
  }
  
  public List<WSFriendItemData> a()
  {
    List localList2 = this.jdField_a_of_type_JavaUtilList;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = Collections.emptyList();
    }
    return localList1;
  }
  
  public Set<String> a()
  {
    return a(WeishiUtils.a());
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WeiShiCacheManager.java][clearRedDotPreloadCache] scene:");
    localStringBuilder.append(paramInt);
    WSLog.e("WeiShiCacheManager", localStringBuilder.toString());
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.13(this, paramInt));
  }
  
  public void a(@Nullable stGetFollowedDramasRsp paramstGetFollowedDramasRsp)
  {
    if ((paramstGetFollowedDramasRsp != null) && (paramstGetFollowedDramasRsp.dramas != null))
    {
      if (paramstGetFollowedDramasRsp.dramas.size() == 0) {
        return;
      }
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.16(this, paramstGetFollowedDramasRsp));
    }
  }
  
  public void a(stGetTabsRsp paramstGetTabsRsp)
  {
    if (paramstGetTabsRsp != null)
    {
      if (paramstGetTabsRsp.Tabs == null) {
        return;
      }
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.14(this, paramstGetTabsRsp));
    }
  }
  
  public void a(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.2(this, paramIWeiShiCacheCallback), 8, null, true);
  }
  
  public void a(String paramString)
  {
    a(WeishiUtils.a()).add(paramString);
  }
  
  public void a(List<stFeed> paramList)
  {
    if (c() == 0)
    {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this));
      return;
    }
    if (WSFeedUtils.a(paramList)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this, paramList));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (b() == 0)
    {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.7(this));
      return;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.8(this, new ArrayList(paramList), paramInt));
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, long paramLong, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp.feeds = localArrayList;
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.12(this, localstSimpleGetFeedListRsp, paramInt, localArrayList, paramList, paramLong));
      return;
    }
    a(paramInt);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (a(paramList)) {
      return;
    }
    WSLog.e("WeiShiCacheManager", "[onPause][handleCacheData] to cache");
    a().a(paramList, paramInt);
    WSAioListHelper.a(paramstSimpleMetaFeed, paramString);
  }
  
  public void a(boolean paramBoolean, IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.1(this, paramBoolean, paramIWeiShiCacheCallback), 8, null, true);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_timestamp");
    localStringBuilder.append(paramInt);
    long l1 = WSSharePreferencesUtil.a(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("validTimestamp-currentTimestamp = ");
    localStringBuilder.append(l1);
    localStringBuilder.append("-");
    localStringBuilder.append(l2);
    localStringBuilder.append(" = ");
    localStringBuilder.append(l3);
    WSLog.d("WeiShiCacheManager", localStringBuilder.toString());
    return l3 > 0L;
  }
  
  public void b(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.3(this, new WeakReference(paramIWeiShiCacheCallback)), 8, null, true);
  }
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.10(this, paramList));
    }
  }
  
  public void c(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.4(this, paramIWeiShiCacheCallback), 8, null, true);
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
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.11(this, paramIWeiShiCacheCallback));
  }
  
  public void e(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.15(this, paramIWeiShiCacheCallback), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager
 * JD-Core Version:    0.7.0.1
 */