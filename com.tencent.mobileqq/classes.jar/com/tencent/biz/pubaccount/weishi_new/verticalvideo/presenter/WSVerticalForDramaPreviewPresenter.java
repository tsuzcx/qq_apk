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
  private Intent a;
  
  public WSVerticalForDramaPreviewPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private String a(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && (paramWSVerticalItemData.a() != null)) {
      return paramWSVerticalItemData.a().feed_desc;
    }
    return "";
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if ((paramWSVerticalVideoHolder != null) && ((paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView)))
    {
      paramWSVerticalVideoHolder = (AbsWSVideoItemView)paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
      if ((paramWSVerticalVideoHolder.a() instanceof WSVerticalItemVideoAreaController)) {
        ((WSVerticalItemVideoAreaController)paramWSVerticalVideoHolder.a()).a(0, 100);
      }
    }
  }
  
  private int d()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    if (localWSVerticalVideoHolder == null) {
      return 0;
    }
    return WSVerticalDataUtil.a((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject);
  }
  
  private void k()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    WSDramaVideoExposureEvent localWSDramaVideoExposureEvent = new WSDramaVideoExposureEvent();
    localWSDramaVideoExposureEvent.setCurrentEpisodeNum(d());
    localWSDramaVideoExposureEvent.setFeedInfo(a((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject));
    WSSimpleEventBus.a().a(localWSDramaVideoExposureEvent);
  }
  
  public WSPlayerParam a()
  {
    return WSDramaDataManager.a().a();
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    paramArrayList = WSVerticalDataUtil.a(WSDramaDataManager.a().a());
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.add(paramArrayList);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertIntentFeedList() feed id = ");
    localStringBuilder.append(WSVerticalDataUtil.a(paramArrayList));
    localStringBuilder.append(", episodeNum = ");
    localStringBuilder.append(WSVerticalDataUtil.a(paramArrayList));
    WSLog.a("WSVerticalForDramaPreviewPresenterLog", localStringBuilder.toString());
    return localArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = a();
    if (paramViewHolder == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current_episode_num", d());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_feed_position", paramInt);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_from", paramViewHolder.a());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_play_scene", paramViewHolder.b());
    paramViewHolder.a(8194, this.jdField_a_of_type_AndroidContentIntent);
    k();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void g()
  {
    WSVerticalPageContract.View localView = a();
    if ((this.d) && (localView != null))
    {
      WSLog.b("WSVerticalForDramaPreviewPresenterLog", "[WSVerticalForDramaPresenter.java][doOnPause] back to drama page!");
      a(localView.a().a());
      WSPlayerAudioControl.a().a(false);
      return;
    }
    super.g();
  }
  
  public void h()
  {
    super.h();
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).a();
    if (localObject != null)
    {
      localObject = ((WSPlayerManager)localObject).a();
      if (localObject != null)
      {
        ((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = null;
        ((WSPlayerParam)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
        WSDramaDataManager.a().a((WSPlayerParam)localObject);
        localObject = (WSVerticalItemData)a().jdField_a_of_type_JavaLangObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSVerticalForDramaPreviewPresenter.java][handleOnBackEvent] mCurrentPosition:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", title:");
        localStringBuilder.append(a((WSVerticalItemData)localObject));
        WSLog.d("WSVerticalForDramaPreviewPresenterLog", localStringBuilder.toString());
        WSVerticalDataUtil.a(WSDramaDataManager.a().a(), (WSVerticalItemData)localObject);
      }
    }
  }
  
  public boolean j()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForDramaPreviewPresenter
 * JD-Core Version:    0.7.0.1
 */