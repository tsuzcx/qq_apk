package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbsWSVerticalForDramaPresenter
  extends AbsWSVerticalChoiceVideoPresenter
{
  private WSDramaEpisodeDataFetcher a;
  protected String a;
  protected String b = "";
  private String c;
  
  public AbsWSVerticalForDramaPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSDramaEpisodeDataFetcher = new WSDramaEpisodeDataFetcher();
  }
  
  private WSDramaEpisodeInfo a()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && (localView.a().getItemCount() > 0)) {
      return ((WSVerticalItemData)localView.a().getItem(0)).a();
    }
    return null;
  }
  
  private void a(@AbsWSVerticalForDramaPresenter.WatchRecordReportScene int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDramaWatchRecord() scene = ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.a("WSVerticalForDramaPresenterLog", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)a().getItem(this.jdField_a_of_type_Int);
    WSDramaOperationRecordManager.a(this.jdField_a_of_type_JavaLangString, WSVerticalDataUtil.a((WSVerticalItemData)localObject), WSVerticalDataUtil.a((WSVerticalItemData)localObject), (int)(a().a().a() / 1000L));
  }
  
  private void a(WSDramaEpisodeInfo paramWSDramaEpisodeInfo, String paramString)
  {
    WSDramaVideoPlayEvent localWSDramaVideoPlayEvent = new WSDramaVideoPlayEvent();
    localWSDramaVideoPlayEvent.setDramaId(paramWSDramaEpisodeInfo.a());
    localWSDramaVideoPlayEvent.setEpisodeNum(paramWSDramaEpisodeInfo.a());
    localWSDramaVideoPlayEvent.setEpisodeId(paramString);
    localWSDramaVideoPlayEvent.setDramaInfo(paramWSDramaEpisodeInfo.a());
    localWSDramaVideoPlayEvent.setDramaPreviewPage(false);
    WSSimpleEventBus.a().a(localWSDramaVideoPlayEvent);
    paramWSDramaEpisodeInfo = new StringBuilder();
    paramWSDramaEpisodeInfo.append("[WSVerticalForDramaPresenter.java][dispatchEventForDramaVideoPlay] event:");
    paramWSDramaEpisodeInfo.append(localWSDramaVideoPlayEvent);
    WSLog.e("WSVerticalForDramaPresenterLog", paramWSDramaEpisodeInfo.toString());
  }
  
  private void b(int paramInt)
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = a().a();
    if (localWSVerticalPageAdapter == null) {
      return;
    }
    int i = 0;
    while (i < localWSVerticalPageAdapter.getDataList().size())
    {
      Object localObject = (WSVerticalItemData)localWSVerticalPageAdapter.getDataList().get(i);
      if (localObject != null)
      {
        localObject = ((WSVerticalItemData)localObject).a();
        if ((localObject != null) && (((WSDramaEpisodeInfo)localObject).a() != null))
        {
          localObject = ((WSDramaEpisodeInfo)localObject).a().dramaInfo;
          boolean bool = true;
          if (paramInt != 1) {
            bool = false;
          }
          ((stDramaInfo)localObject).isFollowed = bool;
        }
      }
      i += 1;
    }
  }
  
  private void b(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if (a() != null)
    {
      TextView localTextView = a().a();
      if (localTextView != null)
      {
        if (paramWSVerticalItemData == null) {
          return;
        }
        if (paramWSVerticalItemData.b())
        {
          if (this.c == null) {
            this.c = localTextView.getContext().getString(2131691848);
          }
          paramWSVerticalItemData = this.c;
        }
        else
        {
          paramWSVerticalItemData = "";
        }
        localTextView.setText(paramWSVerticalItemData);
      }
    }
  }
  
  private void k()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = (WSVerticalItemData)((WSVerticalVideoHolder)localObject1).jdField_a_of_type_JavaLangObject;
      if (localObject2 != null)
      {
        localObject1 = ((WSVerticalItemData)localObject2).a();
        if (localObject1 != null)
        {
          localObject2 = ((WSVerticalItemData)localObject2).a();
          if (localObject2 != null) {
            a((WSDramaEpisodeInfo)localObject1, ((stSimpleMetaFeed)localObject2).id);
          }
        }
      }
    }
  }
  
  private void l()
  {
    if (a() != null)
    {
      if (a() == null) {
        return;
      }
      WSVerticalBeaconReport.h(a().a(), a().b(), a().a(), b());
    }
  }
  
  private void m()
  {
    if (a() == null) {
      return;
    }
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a().a();
    if (localVideoFeedsRecyclerView == null) {
      return;
    }
    int i = 0;
    while (i < localVideoFeedsRecyclerView.getChildCount())
    {
      RecyclerView.ViewHolder localViewHolder = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
      if ((localViewHolder instanceof WSVerticalCommonVideoHolder)) {
        ((WSVerticalVideoHolder)localViewHolder).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.d(3);
      }
      i += 1;
    }
  }
  
  public String a()
  {
    if (a() == null) {
      return "";
    }
    return a().b();
  }
  
  public Map<String, String> a()
  {
    return a(false);
  }
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = a();
    int i;
    if (localObject != null) {
      i = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a().a().dramaInfo.curPublishedFeedNum;
    } else {
      i = -1;
    }
    localObject = super.a(paramWSVerticalItemData);
    ((Map)localObject).put("micro_drama_id", this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put("micro_drama_num", String.valueOf(i));
    ((Map)localObject).put("cover_drama_num", String.valueOf(paramWSVerticalItemData.a().a()));
    ((Map)localObject).put("cover_feedid", paramWSVerticalItemData.a().id);
    return localObject;
  }
  
  @NonNull
  public Map<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", this.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(WSVerticalDataUtil.a(a()));
    ((StringBuilder)localObject).append("");
    localHashMap.put("micro_drama_num", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (this.e) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_clear", localObject);
    }
    localHashMap.put("ref_feedid", c());
    return localHashMap;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("drama_id");
    this.b = paramBundle.getString("current_episode_id");
    paramBundle = new StringBuilder();
    paramBundle.append("mIntentDramaId = ");
    paramBundle.append(this.jdField_a_of_type_JavaLangString);
    paramBundle.append(", mIntentFeedId = ");
    paramBundle.append(this.b);
    WSLog.a("WSVerticalForDramaPresenterLog", paramBundle.toString());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.jdField_a_of_type_Int = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    b(a());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    super.a(paramWSSimpleBaseEvent);
    if ((paramWSSimpleBaseEvent instanceof WSDramaFollowEvent))
    {
      b(((WSDramaFollowEvent)paramWSSimpleBaseEvent).getStatus());
      m();
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    super.a(paramWSPlayerParam);
    k();
    a(1);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    a(2);
  }
  
  protected boolean a(String paramString)
  {
    paramString = new WSDramaEpisodeParams(false, false, this.jdField_a_of_type_JavaLangString, this.b, false);
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSDramaEpisodeDataFetcher.a(paramString, this);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = new WSDramaEpisodeParams(paramBoolean2, paramBoolean1, this.jdField_a_of_type_JavaLangString, this.b, true);
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSDramaEpisodeDataFetcher.a(paramString, this);
  }
  
  public String b()
  {
    WSDramaEpisodeInfo localWSDramaEpisodeInfo = a();
    if ((localWSDramaEpisodeInfo != null) && (localWSDramaEpisodeInfo.a() != null)) {
      return WSDramaUtils.a(BaseApplicationImpl.getContext(), localWSDramaEpisodeInfo.a().dramaInfo);
    }
    return "";
  }
  
  public Map<String, String> b()
  {
    Map localMap = super.b();
    localMap.putAll(a(true));
    return localMap;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    a().a(WSExpABTestManager.a().g());
    a().b(true);
  }
  
  public boolean e()
  {
    WSDramaEpisodeDataFetcher localWSDramaEpisodeDataFetcher = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSDramaEpisodeDataFetcher;
    return (localWSDramaEpisodeDataFetcher == null) || (localWSDramaEpisodeDataFetcher.b);
  }
  
  public boolean f()
  {
    WSDramaEpisodeDataFetcher localWSDramaEpisodeDataFetcher = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSDramaEpisodeDataFetcher;
    return (localWSDramaEpisodeDataFetcher == null) || (localWSDramaEpisodeDataFetcher.a);
  }
  
  public void g()
  {
    super.g();
    a(3);
  }
  
  public void j()
  {
    super.j();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalForDramaPresenter
 * JD-Core Version:    0.7.0.1
 */