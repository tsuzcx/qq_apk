package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.EggsUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class BusinessEggsAnimation$1
  implements View.OnClickListener
{
  BusinessEggsAnimation$1(BusinessEggsAnimation paramBusinessEggsAnimation, BusinessEggsElement paramBusinessEggsElement, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    AioAnimationRule localAioAnimationRule = (AioAnimationRule)BusinessEggsAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement.a));
    if (localAioAnimationRule != null)
    {
      if (!"HTML".equals(localAioAnimationRule.b)) {
        break label116;
      }
      if (!TextUtils.isEmpty(localAioAnimationRule.a))
      {
        Context localContext = paramView.getContext();
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("url", localAioAnimationRule.a);
        localContext.startActivity(localIntent);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        EggsUtil.a(null, "0X800B072", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localAioAnimationRule);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      QLog.e("BusinessEggsAnimation", 1, "[initElementPathStrategy] jump type not define: " + localAioAnimationRule.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation.1
 * JD-Core Version:    0.7.0.1
 */