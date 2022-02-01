package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;

public class WSFollowFriendFeedHolder
  extends BaseViewHolder<WSFriendItemData>
{
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(5.0F);
  private static final int jdField_b_of_type_Int = WSFeedUtils.a(2.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSFriendItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData;
  private WSFollowFriendFeedAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private RoundTextView jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private int c;
  
  private WSFollowFriendFeedHolder(ViewGroup paramViewGroup, WSFollowFriendFeedAdapter paramWSFollowFriendFeedAdapter)
  {
    super(paramViewGroup, 2131560527);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter = paramWSFollowFriendFeedAdapter;
    d();
  }
  
  public static WSFollowFriendFeedHolder a(ViewGroup paramViewGroup, WSFollowFriendFeedAdapter paramWSFollowFriendFeedAdapter)
  {
    return new WSFollowFriendFeedHolder(paramViewGroup, paramWSFollowFriendFeedAdapter);
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(String.valueOf(paramInt));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131382024));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131382026));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131382051));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)a(2131382030));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131382005));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131382012));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131382011));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSFollowFriendFeedHolder.1(this));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSFollowFriendFeedHolder.2(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderInnerPadding(5);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(a().getResources().getColor(2131167374));
  }
  
  private void e()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter == null) || (localstSimpleMetaPerson == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData == null)) {
      return;
    }
    WSFeedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.a(), localstSimpleMetaPerson.avatarSchema, 0, localstSimpleMetaPerson.id);
    WSFollowBeaconReport.b(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a());
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      WSLog.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
      return;
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    WSUserBusiness.a().a(localstSimpleMetaPerson.id, 1);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new WSFollowFriendFeedHolder.4(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  public stSimpleMetaPerson a()
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) {
      return this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    }
    return null;
  }
  
  public void a()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if (WSFeedUtils.a(localstSimpleMetaPerson)) {
      WSLiveAnimationManager.a().a(this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localstSimpleMetaPerson.avatar, new WSFollowFriendFeedHolder.3(this));
    }
  }
  
  public void a(WSFriendItemData paramWSFriendItemData, int paramInt)
  {
    if ((paramWSFriendItemData == null) || (((ArrayList)paramWSFriendItemData.a()).size() < 1)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData = paramWSFriendItemData;
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((ArrayList)paramWSFriendItemData.a()).get(0));
    } while (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null);
    this.c = paramInt;
    a(paramWSFriendItemData.a());
    a(paramWSFriendItemData.a());
    paramWSFriendItemData = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    if (paramWSFriendItemData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      }
      if (!WSFeedUtils.a(paramWSFriendItemData.followStatus)) {
        break label188;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    for (;;)
    {
      WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, true, "focus", this.c);
      WeishiUtils.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramWSFriendItemData.avatar);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramWSFriendItemData.nick);
      if (!WSFeedUtils.a(paramWSFriendItemData)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
      label188:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    }
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = Color.parseColor("#67FFFFFF");; i = Color.parseColor("#FF7A46FF"))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(i);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData == null)
    {
      WSLog.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
      return;
    }
    WSFollowBeaconReport.a(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.followStatus))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
  }
  
  public void h()
  {
    super.h();
    WSLiveAnimationManager.a().a(this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder
 * JD-Core Version:    0.7.0.1
 */