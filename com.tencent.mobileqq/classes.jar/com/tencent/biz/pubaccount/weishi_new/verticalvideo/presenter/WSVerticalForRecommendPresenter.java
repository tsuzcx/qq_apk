package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
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
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class WSVerticalForRecommendPresenter
  extends AbsWSVerticalPagePresenter
{
  public WSVerticalForRecommendPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  @Nullable
  private stSimpleMetaFeed a()
  {
    WSVerticalPageContract.View localView = a();
    Object localObject2;
    if (localView == null) {
      localObject2 = null;
    }
    Object localObject3;
    Object localObject1;
    int i;
    do
    {
      do
      {
        WSVerticalItemData localWSVerticalItemData;
        do
        {
          return localObject2;
          localWSVerticalItemData = localView.a().a();
          WSLog.a("WSVerticalForRecommendPresenter", "handleOnBackEvent");
          localObject3 = WSInitializeHelper.a().a();
          localObject2 = localObject3;
        } while (localObject3 != null);
        localObject1 = localObject3;
        if (localWSVerticalItemData != null)
        {
          localObject1 = localObject3;
          if ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
            localObject1 = localWSVerticalItemData.a();
          }
        }
        if ((localObject1 == null) || (TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc))) {
          break;
        }
        localObject2 = localObject1;
      } while (((stSimpleMetaFeed)localObject1).video_type != 2);
      i = localView.a().a();
      localObject3 = localView.a().b();
      localObject2 = localObject1;
    } while (i >= ((List)localObject3).size() - 2);
    i += 1;
    if (i < ((List)localObject3).size())
    {
      localObject2 = ((WSVerticalItemData)((List)localObject3).get(i)).a();
      if (((stSimpleMetaFeed)localObject2).video_type == 2) {}
      for (;;)
      {
        i += 1;
        break;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject2).feed_desc)) {
          return localObject1;
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
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
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return WSVerticalDataUtil.a(a(paramArrayList));
  }
  
  protected void a()
  {
    WSLog.e("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] saveFeed and cache");
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).a();
      if (localObject != null)
      {
        localList = ((WSVerticalPageAdapter)localObject).b();
        if ((localList != null) && (localList.size() > 0)) {
          break label53;
        }
      }
    }
    WSLog.a("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] view == null");
    return;
    label53:
    localObject = a();
    List localList = WSVerticalDataUtil.b(localList);
    localList.remove(localObject);
    WeiShiCacheManager.a().a(localList, (stSimpleMetaFeed)localObject, localList.size());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSLog.d("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    WSVerticalPageContract.View localView = a();
    if (localView == null) {}
    do
    {
      do
      {
        return;
        if ((paramViewHolder instanceof WSVerticalVideoHolder))
        {
          paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), ((WSVerticalVideoHolder)paramViewHolder).a });
          StoryDispatcher.a().dispatch(paramViewHolder);
        }
      } while (paramInt <= 0);
      if (WSGlobalConfig.a().a(paramInt, 2))
      {
        localView.a(paramInt, 2);
        return;
      }
    } while (WSGlobalConfig.a().d(2) != paramInt);
    localView.a(WSGlobalConfig.a().a(2));
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
  
  protected boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    WSReportUtils.b();
    WSVerticalBeaconReport.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */