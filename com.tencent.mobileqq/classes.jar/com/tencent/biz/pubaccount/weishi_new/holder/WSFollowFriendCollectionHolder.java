package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stFriendFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSTipsInfoDialog;
import com.tencent.biz.pubaccount.weishi_new.follow.WSFriendItemDataUtil;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSFollowFriendCollectionHolder
  extends BaseViewHolder<stFeed>
  implements View.OnClickListener
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  private WSFollowFriendFeedAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter;
  
  private WSFollowFriendCollectionHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131560526);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = paramWSFollowAdapter;
    c();
  }
  
  public static WSFollowFriendCollectionHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowFriendCollectionHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368051));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376728));
    TextView localTextView1 = (TextView)a(2131382043);
    TextView localTextView2 = (TextView)a(2131382044);
    ImageView localImageView = (ImageView)a(2131382014);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131720710);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter = new WSFollowFriendFeedAdapter(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new WSItemDecoration());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.a(new WSFollowFriendCollectionHolder.1(this));
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      int i = j;
      while (i <= k - j)
      {
        RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localViewHolder instanceof BaseViewHolder)) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.a((BaseViewHolder)localViewHolder);
        }
        i += 1;
      }
    }
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramstFeed = paramstFeed.friendFeed;
      List localList = WSFriendItemDataUtil.a(paramstFeed);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.a(localList);
    } while (paramstFeed == null);
    WSFriendFeedDataManager.a().a(paramstFeed.attachInfo);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof WSFollowFriendFeedHolder)) {
            ((WSFollowFriendFeedHolder)localViewHolder).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void h()
  {
    super.h();
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
      WSVerticalPageFragment.a(a(), "friend_feed", "friend", null, 0);
      WSFollowBeaconReport.b();
      continue;
      WSTipsInfoDialog localWSTipsInfoDialog = new WSTipsInfoDialog(a());
      if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.friendFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips))) {
        localWSTipsInfoDialog.a(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips);
      }
      localWSTipsInfoDialog.show();
      WSFollowBeaconReport.a();
      WSFollowBeaconReport.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder
 * JD-Core Version:    0.7.0.1
 */