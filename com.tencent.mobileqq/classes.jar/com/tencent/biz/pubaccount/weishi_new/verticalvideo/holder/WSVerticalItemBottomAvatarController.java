package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemBottomAvatarController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private static final int d = ScreenUtil.dip2px(2.5F);
  private static final int e = ScreenUtil.dip2px(150.0F);
  private static final int f = ScreenUtil.dip2px(1.0F);
  private static final int g = Color.parseColor("#5CFFFFFF");
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TextView b;
  
  public WSVerticalItemBottomAvatarController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(8);
      return;
    }
    if (WSFeedUtils.a(paramstSimpleMetaPerson))
    {
      b(paramstSimpleMetaPerson);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(8);
      return;
    }
    d(paramstSimpleMetaPerson);
  }
  
  private void d(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(0);
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, paramstSimpleMetaPerson.avatar);
  }
  
  private void e(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int i = this.b.getWidth();
    int j = WeishiUIUtil.c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(j - i - e);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaPerson.nick);
    i = WSFeedUtils.a(paramstSimpleMetaPerson.medal);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(f);
    if (i != -1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, a().getDrawable(i), null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void f()
  {
    WSVerticalJumpUtils.a("profile", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void g()
  {
    WSVerticalJumpUtils.a("nickname", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void h()
  {
    if (!NetworkUtil.a(a())) {
      ToastUtil.a().a(2131720723);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    this.b.setVisibility(8);
    WSUserBusiness.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.id, 1);
    WSVerticalBeaconReport.e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData == null) {}
    while (!(localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i = 8;
    if (paramstSimpleMetaPerson == null)
    {
      this.b.setVisibility(8);
      return;
    }
    if (TextUtils.equals(WeishiUtils.d(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    TextView localTextView = this.b;
    if (WSFeedUtils.a(paramstSimpleMetaPerson.followStatus)) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      return;
      i = 0;
    }
  }
  
  public int b()
  {
    return 2131560150;
  }
  
  @UiThread
  public void b()
  {
    Object localObject = (WSVerticalItemData)a();
    if (localObject == null) {}
    while (!(((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = ((WSVerticalItemData)localObject).a().poster;
    a((stSimpleMetaPerson)localObject);
    e((stSimpleMetaPerson)localObject);
    c((stSimpleMetaPerson)localObject);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster))
    {
      WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramstSimpleMetaPerson.avatar, new WSVerticalItemBottomAvatarController.1(this, paramstSimpleMetaPerson));
      return;
    }
    WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131381192));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131381193));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeWidth(d);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeColor(g);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381197));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131381196));
    this.b.setOnClickListener(this);
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
      f();
      continue;
      g();
      continue;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomAvatarController
 * JD-Core Version:    0.7.0.1
 */