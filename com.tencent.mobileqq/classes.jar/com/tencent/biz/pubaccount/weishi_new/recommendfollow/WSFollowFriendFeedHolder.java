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
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
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
    super(paramViewGroup, 2131560414);
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)getView(2131381229));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)getView(2131381231));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getView(2131381254));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)getView(2131381235));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getView(2131381210));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)getView(2131381217));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)getView(2131381216));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSFollowFriendFeedHolder.1(this));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSFollowFriendFeedHolder.2(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderInnerPadding(5);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(getContext().getResources().getColor(2131167394));
  }
  
  private void e()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    WSFollowFriendFeedAdapter localWSFollowFriendFeedAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter;
    if ((localWSFollowFriendFeedAdapter != null) && (localstSimpleMetaPerson != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData == null) {
        return;
      }
      WSFeedUtils.a(localWSFollowFriendFeedAdapter.a(), localstSimpleMetaPerson.avatarSchema, 0, localstSimpleMetaPerson.id);
      WSFollowBeaconReport.b(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a());
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if ((localObject != null) && (((stSimpleMetaFeed)localObject).poster != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
      WSUserBusiness.a().a(((stSimpleMetaPerson)localObject).id, 1);
      return;
    }
    WSLog.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new WSFollowFriendFeedHolder.4(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  public stSimpleMetaPerson a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.poster;
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
    if (paramWSFriendItemData != null)
    {
      if (((ArrayList)paramWSFriendItemData.a()).size() < 1) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData = paramWSFriendItemData;
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((ArrayList)paramWSFriendItemData.a()).get(0));
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) {
        return;
      }
      this.c = paramInt;
      a(paramWSFriendItemData.a());
      a(paramWSFriendItemData.a());
      paramWSFriendItemData = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
      if (paramWSFriendItemData != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
        }
        if (WSFeedUtils.a(paramWSFriendItemData.followStatus))
        {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        }
        WSPicLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, true, "focus", this.c);
        WSPicLoader.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramWSFriendItemData.avatar);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramWSFriendItemData.nick);
      }
      if (WSFeedUtils.a(paramWSFriendItemData))
      {
        this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "#67FFFFFF";
    } else {
      str = "#FF7A46FF";
    }
    int i = Color.parseColor(str);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(i);
  }
  
  public void b()
  {
    WSFriendItemData localWSFriendItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData;
    if (localWSFriendItemData == null)
    {
      WSLog.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
      return;
    }
    WSFollowBeaconReport.a(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, localWSFriendItemData.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowDataWSFriendItemData.a());
  }
  
  public void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if (localstSimpleMetaFeed != null)
    {
      if (localstSimpleMetaFeed.poster == null) {
        return;
      }
      if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.followStatus))
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    WSLiveAnimationManager.a().a(this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder
 * JD-Core Version:    0.7.0.1
 */