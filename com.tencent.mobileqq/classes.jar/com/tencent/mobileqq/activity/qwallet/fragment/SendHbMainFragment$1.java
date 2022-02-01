package com.tencent.mobileqq.activity.qwallet.fragment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.QwUtils;
import org.json.JSONObject;

class SendHbMainFragment$1
  implements View.OnClickListener
{
  SendHbMainFragment$1(SendHbMainFragment paramSendHbMainFragment, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    if (QwUtils.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbMainFragment.openUrl(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment.1
 * JD-Core Version:    0.7.0.1
 */