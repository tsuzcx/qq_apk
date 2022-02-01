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
  protected String a = "";
  protected String b = "";
  private String i;
  private WSDramaEpisodeDataFetcher j = new WSDramaEpisodeDataFetcher();
  
  public AbsWSVerticalForDramaPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private WSDramaEpisodeInfo O()
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.b() != null) && (localView.b().getItemCount() > 0)) {
      return ((WSVerticalItemData)localView.b().getItem(0)).g();
    }
    return null;
  }
  
  private void P()
  {
    Object localObject1 = K();
    if (localObject1 != null)
    {
      Object localObject2 = (WSVerticalItemData)((WSVerticalVideoHolder)localObject1).e;
      if (localObject2 != null)
      {
        localObject1 = ((WSVerticalItemData)localObject2).g();
        if (localObject1 != null)
        {
          localObject2 = ((WSVerticalItemData)localObject2).b();
          if (localObject2 != null) {
            a((WSDramaEpisodeInfo)localObject1, ((stSimpleMetaFeed)localObject2).id);
          }
        }
      }
    }
  }
  
  private void Q()
  {
    if (z() != null)
    {
      if (L() == null) {
        return;
      }
      WSVerticalBeaconReport.i(z().k(), z().l(), L().b(), n());
    }
  }
  
  private void R()
  {
    if (z() == null) {
      return;
    }
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = z().c();
    if (localVideoFeedsRecyclerView == null) {
      return;
    }
    int k = 0;
    while (k < localVideoFeedsRecyclerView.getChildCount())
    {
      RecyclerView.ViewHolder localViewHolder = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(k));
      if ((localViewHolder instanceof WSVerticalCommonVideoHolder)) {
        ((WSVerticalVideoHolder)localViewHolder).c.d(3);
      }
      k += 1;
    }
  }
  
  private void a(WSDramaEpisodeInfo paramWSDramaEpisodeInfo, String paramString)
  {
    WSDramaVideoPlayEvent localWSDramaVideoPlayEvent = new WSDramaVideoPlayEvent();
    localWSDramaVideoPlayEvent.setDramaId(paramWSDramaEpisodeInfo.a());
    localWSDramaVideoPlayEvent.setEpisodeNum(paramWSDramaEpisodeInfo.c());
    localWSDramaVideoPlayEvent.setEpisodeId(paramString);
    localWSDramaVideoPlayEvent.setDramaInfo(paramWSDramaEpisodeInfo.d());
    localWSDramaVideoPlayEvent.setDramaPreviewPage(false);
    WSSimpleEventBus.a().a(localWSDramaVideoPlayEvent);
    paramWSDramaEpisodeInfo = new StringBuilder();
    paramWSDramaEpisodeInfo.append("[WSVerticalForDramaPresenter.java][dispatchEventForDramaVideoPlay] event:");
    paramWSDramaEpisodeInfo.append(localWSDramaVideoPlayEvent);
    WSLog.e("WSVerticalForDramaPresenterLog", paramWSDramaEpisodeInfo.toString());
  }
  
  private void d(@AbsWSVerticalForDramaPresenter.WatchRecordReportScene int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDramaWatchRecord() scene = ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.a("WSVerticalForDramaPresenterLog", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)J().getItem(this.g);
    WSDramaOperationRecordManager.a(this.a, WSVerticalDataUtil.c((WSVerticalItemData)localObject), WSVerticalDataUtil.a((WSVerticalItemData)localObject), (int)(J().d().a() / 1000L));
  }
  
  private void d(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if (z() != null)
    {
      TextView localTextView = z().d();
      if (localTextView != null)
      {
        if (paramWSVerticalItemData == null) {
          return;
        }
        if (paramWSVerticalItemData.c())
        {
          if (this.i == null) {
            this.i = localTextView.getContext().getString(2131888813);
          }
          paramWSVerticalItemData = this.i;
        }
        else
        {
          paramWSVerticalItemData = "";
        }
        localTextView.setText(paramWSVerticalItemData);
      }
    }
  }
  
  private void e(int paramInt)
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = z().b();
    if (localWSVerticalPageAdapter == null) {
      return;
    }
    int k = 0;
    while (k < localWSVerticalPageAdapter.getDataList().size())
    {
      Object localObject = (WSVerticalItemData)localWSVerticalPageAdapter.getDataList().get(k);
      if (localObject != null)
      {
        localObject = ((WSVerticalItemData)localObject).g();
        if ((localObject != null) && (((WSDramaEpisodeInfo)localObject).d() != null))
        {
          localObject = ((WSDramaEpisodeInfo)localObject).d().dramaInfo;
          boolean bool = true;
          if (paramInt != 1) {
            bool = false;
          }
          ((stDramaInfo)localObject).isFollowed = bool;
        }
      }
      k += 1;
    }
  }
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = K();
    int k;
    if (localObject != null) {
      k = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).g().d().dramaInfo.curPublishedFeedNum;
    } else {
      k = -1;
    }
    localObject = super.a(paramWSVerticalItemData);
    ((Map)localObject).put("micro_drama_id", this.a);
    ((Map)localObject).put("micro_drama_num", String.valueOf(k));
    ((Map)localObject).put("cover_drama_num", String.valueOf(paramWSVerticalItemData.g().c()));
    ((Map)localObject).put("cover_feedid", paramWSVerticalItemData.b().id);
    return localObject;
  }
  
  @NonNull
  public Map<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(WSVerticalDataUtil.a(L()));
    ((StringBuilder)localObject).append("");
    localHashMap.put("micro_drama_num", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (this.h) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_clear", localObject);
    }
    localHashMap.put("ref_feedid", y());
    return localHashMap;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a = paramBundle.getString("drama_id");
    this.b = paramBundle.getString("current_episode_id");
    paramBundle = new StringBuilder();
    paramBundle.append("mIntentDramaId = ");
    paramBundle.append(this.a);
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
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.f = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.e });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    d(L());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    super.a(paramWSSimpleBaseEvent);
    if ((paramWSSimpleBaseEvent instanceof WSDramaFollowEvent))
    {
      e(((WSDramaFollowEvent)paramWSSimpleBaseEvent).getStatus());
      R();
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    super.a(paramWSPlayerParam);
    P();
    d(1);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    d(2);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = new WSDramaEpisodeParams(paramBoolean2, paramBoolean1, this.a, this.b, true);
    return this.j.a(paramString, this);
  }
  
  protected boolean c(String paramString)
  {
    paramString = new WSDramaEpisodeParams(false, false, this.a, this.b, false);
    return this.j.a(paramString, this);
  }
  
  public void e()
  {
    J().a(WSExpABTestManager.a().s());
    J().b(true);
  }
  
  public void g()
  {
    super.g();
    d(3);
  }
  
  public Map<String, String> m()
  {
    return a(false);
  }
  
  public Map<String, String> n()
  {
    Map localMap = super.n();
    localMap.putAll(a(true));
    return localMap;
  }
  
  public boolean p()
  {
    return true;
  }
  
  public void q()
  {
    super.q();
    Q();
  }
  
  public boolean u()
  {
    WSDramaEpisodeDataFetcher localWSDramaEpisodeDataFetcher = this.j;
    return (localWSDramaEpisodeDataFetcher == null) || (localWSDramaEpisodeDataFetcher.b);
  }
  
  public boolean v()
  {
    WSDramaEpisodeDataFetcher localWSDramaEpisodeDataFetcher = this.j;
    return (localWSDramaEpisodeDataFetcher == null) || (localWSDramaEpisodeDataFetcher.a);
  }
  
  public String w()
  {
    if (O() == null) {
      return "";
    }
    return O().b();
  }
  
  public String x()
  {
    WSDramaEpisodeInfo localWSDramaEpisodeInfo = O();
    if ((localWSDramaEpisodeInfo != null) && (localWSDramaEpisodeInfo.d() != null)) {
      return WSDramaUtils.a(BaseApplicationImpl.getContext(), localWSDramaEpisodeInfo.d().dramaInfo);
    }
    return "";
  }
  
  public String y()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalForDramaPresenter
 * JD-Core Version:    0.7.0.1
 */