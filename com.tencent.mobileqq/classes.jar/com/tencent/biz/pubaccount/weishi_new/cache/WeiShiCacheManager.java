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
  private List<WSFriendItemData> a;
  private Map<String, Set<String>> b;
  
  @NotNull
  private stSimpleGetFeedListRsp a(boolean paramBoolean)
  {
    WSLog.b("WeiShiCacheManager", "读取瀑布流缓存数据");
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp1.feeds = new ArrayList();
    if (paramBoolean)
    {
      localstSimpleGetFeedListRsp2 = d(4);
      if ((localstSimpleGetFeedListRsp2 != null) && (localstSimpleGetFeedListRsp2.feeds != null)) {
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
      }
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = d(1);
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
      str = i();
    } else if (paramInt == 2) {
      str = k();
    } else if (paramInt == 5) {
      str = l();
    } else if (paramInt == 3) {
      str = n();
    } else if (paramInt == 4) {
      str = j();
    } else if (paramInt == 6) {
      str = m();
    } else if (paramInt == 7) {
      str = o();
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return WSFileUtils.b(paramT, str);
  }
  
  public static WeiShiCacheManager a()
  {
    return WeiShiCacheManager.SingletonHolder.a();
  }
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    return WSFileUtils.a(paramJceStruct, paramString);
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_feed_id");
    localStringBuilder.append(paramInt);
    return WSSharePreferencesUtil.b(localStringBuilder.toString(), "");
  }
  
  @NotNull
  private Set<String> b(String paramString)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    Set localSet = (Set)this.b.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.b.put(paramString, localObject);
    }
    return localObject;
  }
  
  private stSimpleGetFeedListRsp d(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  private boolean d(List<stSimpleMetaFeed> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return true;
      }
      int i = ((stSimpleMetaFeed)paramList.get(paramList.size() - 1)).hashCode();
      if (i == WSInitializeHelper.a().g())
      {
        WSLog.e("WeiShiCacheManager", "[onPause][handleCacheData] has been cached，not cache again");
        return true;
      }
      WSInitializeHelper.a().a(i);
      return false;
    }
    return true;
  }
  
  private String e(int paramInt)
  {
    if (paramInt == 13) {
      return l();
    }
    return k();
  }
  
  private int f()
  {
    return WSGlobalConfig.a().n();
  }
  
  private int g()
  {
    return WSFeedDataManager.a().e;
  }
  
  private stSimpleGetFeedListRsp h()
  {
    if ((a(8)) && (b() >= 8))
    {
      WSLog.b("WeiShiCacheManager", "仅读取红点缓存");
      return d(2);
    }
    WSLog.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
    Object localObject = d(2);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = d(1);
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
  
  private String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_recommend_data");
    return localStringBuilder.toString();
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_recommend_vertical_data");
    return localStringBuilder.toString();
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_falls_preload_feeds");
    return localStringBuilder.toString();
  }
  
  private String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_immersive_preload_feeds");
    return localStringBuilder.toString();
  }
  
  private String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_tabs_info_");
    localStringBuilder.append(WeishiUtils.c());
    return localStringBuilder.toString();
  }
  
  private String n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_follow_data_");
    localStringBuilder.append(WeishiUtils.c());
    return localStringBuilder.toString();
  }
  
  private String o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_follow_drama_data_");
    localStringBuilder.append(WeishiUtils.c());
    return localStringBuilder.toString();
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
    b(WeishiUtils.c()).add(paramString);
  }
  
  public void a(List<stFeed> paramList)
  {
    if (g() == 0)
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
    if (f() == 0)
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
    c(paramInt);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (d(paramList)) {
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
  
  public boolean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_timestamp");
    localStringBuilder.append(paramInt);
    long l1 = WSSharePreferencesUtil.b(localStringBuilder.toString(), 0L);
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
  
  public int b()
  {
    return WSSharePreferencesUtil.b("key_red_msg_valid_count", 0);
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
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WeiShiCacheManager.java][clearRedDotPreloadCache] scene:");
    localStringBuilder.append(paramInt);
    WSLog.e("WeiShiCacheManager", localStringBuilder.toString());
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.13(this, paramInt));
  }
  
  public void c(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.4(this, paramIWeiShiCacheCallback), 8, null, true);
  }
  
  public void c(List<WSFriendItemData> paramList)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public Set<String> d()
  {
    return b(WeishiUtils.c());
  }
  
  public void d(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.11(this, paramIWeiShiCacheCallback));
  }
  
  public List<WSFriendItemData> e()
  {
    List localList2 = this.a;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = Collections.emptyList();
    }
    return localList1;
  }
  
  public void e(IWeiShiCacheCallback paramIWeiShiCacheCallback)
  {
    ThreadManager.post(new WeiShiCacheManager.15(this, paramIWeiShiCacheCallback), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager
 * JD-Core Version:    0.7.0.1
 */