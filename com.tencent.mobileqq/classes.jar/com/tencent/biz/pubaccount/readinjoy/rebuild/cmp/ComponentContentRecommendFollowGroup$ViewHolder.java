package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.GroupRecommendAccount;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ComponentContentRecommendFollowGroup$ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GroupRecommendAccount jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructGroupRecommendAccount;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView;
  ImageView[] c;
  
  private ComponentContentRecommendFollowGroup$ViewHolder(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131367289: 
      i = 0;
      label50:
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructGroupRecommendAccount.a.size()) {
        if (((RecommendFollowInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructGroupRecommendAccount.a.get(i)).isFollowed) {
          break;
        }
      }
      break;
    }
    for (int i = 0;; i = 1)
    {
      ComponentContentRecommendFollowGroup localComponentContentRecommendFollowGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup;
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructGroupRecommendAccount.a;
      if (i == 0) {}
      for (;;)
      {
        localComponentContentRecommendFollowGroup.a(localList, bool);
        break;
        i += 1;
        break label50;
        bool = false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup.a((RecommendFollowInfo)paramView.getTag());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.ViewHolder
 * JD-Core Version:    0.7.0.1
 */