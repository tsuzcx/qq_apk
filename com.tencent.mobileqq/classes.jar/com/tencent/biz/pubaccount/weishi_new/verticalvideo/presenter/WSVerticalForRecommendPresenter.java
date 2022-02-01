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
  
  private ArrayList b(ArrayList paramArrayList)
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
  
  private void u()
  {
    WSVerticalPageContract.View localView = z();
    if (localView != null) {
      WSVerticalBeaconReport.b(localView.m());
    }
  }
  
  protected boolean B()
  {
    return true;
  }
  
  protected void P()
  {
    WSLog.e("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] saveFeed and cache");
    if (y()) {
      return;
    }
    Object localObject = z();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).b();
      if (localObject != null)
      {
        List localList = ((WSVerticalPageAdapter)localObject).getDataList();
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = N();
          localList = WSVerticalDataUtil.b(localList);
          localList.remove(localObject);
          WeiShiCacheManager.a().a(localList, (stSimpleMetaFeed)localObject, localList.size(), WSVerticalBeaconReport.c(z().k()));
          return;
        }
      }
    }
    WSLog.a("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] view == null");
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return WSVerticalDataUtil.a(b(paramArrayList));
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
      WSReportUtils.c(paramBundle);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WSVerticalForRecommendPresenter onPageSelected: ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WSVerticalForRecommendPresenter", ((StringBuilder)localObject).toString());
    localObject = z();
    if (localObject == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.f = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.e });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    if (paramInt > 0)
    {
      if (WSGlobalConfig.a().a(paramInt, 2))
      {
        ((WSVerticalPageContract.View)localObject).a(paramInt, 2);
        return;
      }
      if (WSGlobalConfig.a().e(2) == paramInt) {
        ((WSVerticalPageContract.View)localObject).a(WSGlobalConfig.a().a(2));
      }
    }
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = z();
    if (paramString == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForRecommendPresenter.1(this, paramBoolean1, paramBoolean2, paramString));
    return true;
  }
  
  public void destroy()
  {
    super.destroy();
    WSReportUtils.d();
    WSVerticalBeaconReport.b("");
  }
  
  public void e()
  {
    super.e();
    u();
  }
  
  public Map<String, String> n()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = b(this.g);
    if (localObject1 != null)
    {
      localObject1 = ((WSVerticalItemData)localObject1).b();
      if (localObject1 == null) {
        return localHashMap;
      }
      Object localObject2 = ((stSimpleMetaFeed)localObject1).collection;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((stCollection)localObject2).cid)))
      {
        localHashMap.put("collection_id", ((stCollection)localObject2).cid);
        localHashMap.put("collection_type", String.valueOf(((stCollection)localObject2).collectionType));
      }
      if ((((stSimpleMetaFeed)localObject1).dramaInfo != null) && (((stSimpleMetaFeed)localObject1).dramaInfo.dramaInfo != null))
      {
        stDramaInfo localstDramaInfo = ((stSimpleMetaFeed)localObject1).dramaInfo.dramaInfo.dramaInfo;
        localObject2 = "";
        if (localstDramaInfo != null) {
          localObject1 = localstDramaInfo.id;
        } else {
          localObject1 = "";
        }
        localHashMap.put("micro_drama_id", localObject1);
        localObject1 = localObject2;
        if (localstDramaInfo != null) {
          localObject1 = String.valueOf(localstDramaInfo.curPublishedFeedNum);
        }
        localHashMap.put("micro_drama_num", localObject1);
      }
    }
    return localHashMap;
  }
  
  protected boolean y()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */