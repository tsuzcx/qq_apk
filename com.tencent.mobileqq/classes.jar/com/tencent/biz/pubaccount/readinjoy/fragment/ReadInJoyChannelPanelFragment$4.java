package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyChannelPanelFragment$4
  implements View.OnClickListener
{
  ReadInJoyChannelPanelFragment$4(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, "info.mChannelJumpUrl:" + this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.4
 * JD-Core Version:    0.7.0.1
 */