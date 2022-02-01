package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stCollection;
import UserGrowth.stDrama;
import UserGrowth.stDramaFall;
import UserGrowth.stDramaInfo;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSVerticalForRecommendPresenter
  extends AbsWSVerticalPagePresenter
{
  public WSVerticalForRecommendPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(0);
      if ((localstSimpleMetaFeed.imgReplacements != null) && (localstSimpleMetaFeed.imgReplacements.size() > 1)) {
        ((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(1)).img = ((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(0)).img;
      }
      if ((localstSimpleMetaFeed.images != null) && (localstSimpleMetaFeed.images.size() > 1)) {
        ((stMetaUgcImage)localstSimpleMetaFeed.images.get(1)).url = ((stMetaUgcImage)localstSimpleMetaFeed.images.get(0)).url;
      }
    }
    return paramArrayList;
  }
  
  private void l()
  {
    WSVerticalPageContract.View localView = a();
    if (localView != null) {
      WSVerticalBeaconReport.b(localView.c());
    }
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return WSVerticalDataUtil.a(a(paramArrayList));
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_fall_list_index");
      String str = paramBundle.getString("key_fall_list_feed_id");
      paramBundle = paramBundle.getString("key_page_session");
      WSVerticalBeaconReport.a(i);
      WSVerticalBeaconReport.a(str);
      WSReportUtils.b(paramBundle);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WSVerticalForRecommendPresenter onPageSelected: ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WSVerticalForRecommendPresenter", ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    if (paramInt > 0)
    {
      if (WSGlobalConfig.a().a(paramInt, 2))
      {
        ((WSVerticalPageContract.View)localObject).a(paramInt, 2);
        return;
      }
      if (WSGlobalConfig.a().d(2) == paramInt) {
        ((WSVerticalPageContract.View)localObject).a(WSGlobalConfig.a().a(2));
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = a();
    if (paramString == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForRecommendPresenter.1(this, paramBoolean1, paramBoolean2, paramString));
    return true;
  }
  
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = a(this.a);
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).a();
      if (localObject == null) {
        return localHashMap;
      }
      stCollection localstCollection = ((stSimpleMetaFeed)localObject).collection;
      if ((localstCollection != null) && (!TextUtils.isEmpty(localstCollection.cid)))
      {
        localHashMap.put("collection_id", localstCollection.cid);
        localHashMap.put("collection_type", String.valueOf(localstCollection.collectionType));
        return localHashMap;
      }
      if ((((stSimpleMetaFeed)localObject).dramaInfo != null) && (((stSimpleMetaFeed)localObject).dramaInfo.dramaInfo != null))
      {
        localObject = ((stSimpleMetaFeed)localObject).dramaInfo.dramaInfo.dramaInfo;
        localHashMap.put("micro_drama_id", ((stDramaInfo)localObject).id);
        localHashMap.put("micro_drama_num", String.valueOf(((stDramaInfo)localObject).curPublishedFeedNum));
      }
    }
    return localHashMap;
  }
  
  public void b()
  {
    super.b();
    WSReportUtils.b();
    WSVerticalBeaconReport.b("");
  }
  
  public void e()
  {
    super.e();
    l();
  }
  
  protected boolean g()
  {
    return true;
  }
  
  protected void k()
  {
    WSLog.e("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] saveFeed and cache");
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).a();
      if (localObject != null)
      {
        List localList = ((WSVerticalPageAdapter)localObject).getDataList();
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = a();
          localList = WSVerticalDataUtil.b(localList);
          localList.remove(localObject);
          WeiShiCacheManager.a().a(localList, (stSimpleMetaFeed)localObject, localList.size(), WSVerticalBeaconReport.a(a().a()));
          return;
        }
      }
    }
    WSLog.a("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] view == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */