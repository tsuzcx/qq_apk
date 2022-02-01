package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stFriendFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager;
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
    super(paramViewGroup, 2131560413);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = paramWSFollowAdapter;
    c();
  }
  
  public static WSFollowFriendCollectionHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowFriendCollectionHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getView(2131367803));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)getView(2131376226));
    TextView localTextView1 = (TextView)getView(2131381246);
    TextView localTextView2 = (TextView)getView(2131381247);
    ImageView localImageView = (ImageView)getView(2131381219);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131720434);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter = new WSFollowFriendFeedAdapter(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new WSItemDecoration());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.setOnItemClickListener(new WSFollowFriendCollectionHolder.1(this));
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if (localObject == null) {
      return;
    }
    int j = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k - j)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
      if ((localObject instanceof BaseViewHolder)) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.a((BaseViewHolder)localObject);
      }
      i += 1;
    }
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramstFeed = paramstFeed.friendFeed;
    List localList = WSFriendItemDataUtil.a(paramstFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSFollowFriendFeedAdapter.fillList(localList);
    if (paramstFeed != null) {
      WSFriendFeedDataManager.a().a(paramstFeed.attachInfo);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter == null) {
        return;
      }
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if (i >= 0)
      {
        if (j >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList().size()) {
          return;
        }
        while (i <= j)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localObject instanceof WSFollowFriendFeedHolder)) {
            ((WSFollowFriendFeedHolder)localObject).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131381219)
    {
      if (i != 2131381246) {
        return;
      }
      WSVerticalPageFragment.a(new WSVerticalPageOpenParams(getContext(), "friend_feed", "friend"));
      WSFollowBeaconReport.b();
      return;
    }
    paramView = new WSTipsInfoDialog(getContext());
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localstFeed != null) && (localstFeed.friendFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips))) {
      paramView.a(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips);
    }
    paramView.show();
    WSFollowBeaconReport.a();
    WSFollowBeaconReport.d();
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder
 * JD-Core Version:    0.7.0.1
 */