package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemBottomOperationController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalItemBottomWidgetViewController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public WSVerticalItemBottomOperationController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramWSVerticalVideoHolder.itemView);
    }
    WSLog.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      WSLog.c("comment", "data hashCode:" + localWSVerticalItemData.hashCode());
      return localWSVerticalItemData.a();
    }
    WSLog.c("comment", "data is null");
    return null;
  }
  
  private boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController = new WSVerticalItemBottomWidgetViewController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController.a(paramWSVerticalItemData);
    }
  }
  
  private int c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.ding_count;
    }
    return 0;
  }
  
  private int d()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null)
    {
      WSLog.c("comment", "itemInfo hashCode:" + localstSimpleMetaFeed.hashCode());
      return localstSimpleMetaFeed.total_comment_num;
    }
    return 0;
  }
  
  private int e()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.share_info != null)) {
      return localstSimpleMetaFeed.share_info.share_num;
    }
    return 0;
  }
  
  private void i()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.shareHidden))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    if (e() > 0)
    {
      VideoFeedsHelper.a(this.c, e(), "0");
      return;
    }
    this.c.setText(2131720725);
  }
  
  private void j()
  {
    Object localObject = a();
    WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), 1000001, (stSimpleMetaFeed)localObject);
    WSReportDC898Vertical.c();
    localObject = new WSShareParam();
    ((WSShareParam)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    ((WSShareParam)localObject).jdField_a_of_type_Int = 3;
    ((WSShareParam)localObject).jdField_b_of_type_Int = a();
    ((WSShareParam)localObject).jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    ((WSShareParam)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    ((WSShareParam)localObject).c = "forward";
    ((WSShareParam)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    WeishiShareUtil.a(this.jdField_a_of_type_AndroidContentContext, (WSShareParam)localObject);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    WSVerticalBeaconReport.g(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
    WsCommentPresenter localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a;
    if (localWsCommentPresenter == null)
    {
      WSLog.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    WSLog.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    localWsCommentPresenter.a(a());
    localWsCommentPresenter.a(WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    localWsCommentPresenter.a(a());
    localWsCommentPresenter.b();
  }
  
  public void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    WSLikeAnimationManger.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewViewGroup);
    WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), localstSimpleMetaFeed);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  public int b()
  {
    return 2131560155;
  }
  
  public void b()
  {
    f();
    g();
    i();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController.b();
    }
  }
  
  public void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      WSLikeAnimationManger.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131381407));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131381406));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381408));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131381404));
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131381297));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131381275));
    this.c = ((TextView)a(2131381489));
    this.c.setOnClickListener(this);
  }
  
  public void f()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.dingHidden))
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(a());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (c() > 0)
    {
      VideoFeedsHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, c(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720722);
  }
  
  public void g()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.commentHidden))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (d() > 0)
    {
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720704);
  }
  
  public void h()
  {
    Object localObject = (WSVerticalItemData)a();
    if ((localObject == null) || (((WSVerticalItemData)localObject).a() == null)) {}
    while (WeishiUtils.c()) {
      return;
    }
    localObject = ((WSVerticalItemData)localObject).a();
    WSLikeAnimationManger.a().a((stSimpleMetaFeed)localObject, a(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewViewGroup);
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      WSVerticalBeaconReport.a(str1, str2, bool, (stSimpleMetaFeed)localObject);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      h();
      continue;
      k();
      continue;
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomOperationController
 * JD-Core Version:    0.7.0.1
 */