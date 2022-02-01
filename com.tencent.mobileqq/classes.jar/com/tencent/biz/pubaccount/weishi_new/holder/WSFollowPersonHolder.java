package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSFollowPersonHolder
  extends BaseViewHolder<stFeed>
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  private WSRecommendFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter;
  
  private WSFollowPersonHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131560526);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = paramWSFollowAdapter;
    b();
  }
  
  public static WSFollowPersonHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowPersonHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368051));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376728));
    TextView localTextView1 = (TextView)a(2131382044);
    TextView localTextView2 = (TextView)a(2131382043);
    ImageView localImageView = (ImageView)a(2131382014);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localTextView1.setText(2131720708);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter = new WSRecommendFollowAdapter(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new WSItemDecoration());
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter.b().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof WSRecommendFollowHolder)) {
            ((WSRecommendFollowHolder)localViewHolder).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter.a(paramstFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowAdapter.a(paramstFeed.person_meta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowPersonHolder
 * JD-Core Version:    0.7.0.1
 */