package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForDramaPreviewPresenter
  extends AbsWSVerticalForDramaPresenter
{
  private Intent i;
  
  public WSVerticalForDramaPreviewPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private void O()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = K();
    WSDramaVideoExposureEvent localWSDramaVideoExposureEvent = new WSDramaVideoExposureEvent();
    localWSDramaVideoExposureEvent.setCurrentEpisodeNum(P());
    localWSDramaVideoExposureEvent.setFeedInfo(b((WSVerticalItemData)localWSVerticalVideoHolder.e));
    WSSimpleEventBus.a().a(localWSDramaVideoExposureEvent);
  }
  
  private int P()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = K();
    if (localWSVerticalVideoHolder == null) {
      return 0;
    }
    return WSVerticalDataUtil.a((WSVerticalItemData)localWSVerticalVideoHolder.e);
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if ((paramWSVerticalVideoHolder != null) && ((paramWSVerticalVideoHolder.c instanceof AbsWSVideoItemView)))
    {
      paramWSVerticalVideoHolder = (AbsWSVideoItemView)paramWSVerticalVideoHolder.c;
      if ((paramWSVerticalVideoHolder.g() instanceof WSVerticalItemVideoAreaController)) {
        ((WSVerticalItemVideoAreaController)paramWSVerticalVideoHolder.g()).a(0, 100);
      }
    }
  }
  
  private String d(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && (paramWSVerticalItemData.b() != null)) {
      return paramWSVerticalItemData.b().feed_desc;
    }
    return "";
  }
  
  public boolean G()
  {
    return false;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    paramArrayList = WSVerticalDataUtil.a(WSDramaDataManager.a().c());
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.add(paramArrayList);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertIntentFeedList() feed id = ");
    localStringBuilder.append(WSVerticalDataUtil.c(paramArrayList));
    localStringBuilder.append(", episodeNum = ");
    localStringBuilder.append(WSVerticalDataUtil.a(paramArrayList));
    WSLog.a("WSVerticalForDramaPreviewPresenterLog", localStringBuilder.toString());
    return localArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = z();
    if (paramViewHolder == null) {
      return;
    }
    if (this.i == null) {
      this.i = new Intent();
    }
    this.i.putExtra("current_episode_num", P());
    this.i.putExtra("key_feed_position", paramInt);
    this.i.putExtra("key_from", paramViewHolder.k());
    this.i.putExtra("key_play_scene", paramViewHolder.l());
    paramViewHolder.a(8194, this.i);
    O();
  }
  
  public void g()
  {
    WSVerticalPageContract.View localView = z();
    if ((this.f) && (localView != null))
    {
      WSLog.b("WSVerticalForDramaPreviewPresenterLog", "[WSVerticalForDramaPresenter.java][doOnPause] back to drama page!");
      a(localView.b().b());
      WSPlayerAudioControl.a().a(false);
      return;
    }
    super.g();
  }
  
  public void h()
  {
    super.h();
    Object localObject = z();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).e();
    if (localObject != null)
    {
      localObject = ((WSPlayerManager)localObject).r();
      if (localObject != null)
      {
        ((WSPlayerParam)localObject).k = null;
        ((WSPlayerParam)localObject).a = null;
        WSDramaDataManager.a().a((WSPlayerParam)localObject);
        localObject = (WSVerticalItemData)K().e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSVerticalForDramaPreviewPresenter.java][handleOnBackEvent] mCurrentPosition:");
        localStringBuilder.append(this.g);
        localStringBuilder.append(", title:");
        localStringBuilder.append(d((WSVerticalItemData)localObject));
        WSLog.d("WSVerticalForDramaPreviewPresenterLog", localStringBuilder.toString());
        WSVerticalDataUtil.a(WSDramaDataManager.a().c(), (WSVerticalItemData)localObject);
      }
    }
  }
  
  public boolean k()
  {
    return true;
  }
  
  public WSPlayerParam l()
  {
    return WSDramaDataManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForDramaPreviewPresenter
 * JD-Core Version:    0.7.0.1
 */