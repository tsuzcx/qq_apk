package com.tencent.biz.pubaccount.ecshopassit.view;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;

class CustomTitleView$9
  implements Runnable
{
  CustomTitleView$9(CustomTitleView paramCustomTitleView, RedPointInfo paramRedPointInfo, ImageView paramImageView) {}
  
  public void run()
  {
    RedPointUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitRedPointInfo.b);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitRedPointInfo.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView.9
 * JD-Core Version:    0.7.0.1
 */