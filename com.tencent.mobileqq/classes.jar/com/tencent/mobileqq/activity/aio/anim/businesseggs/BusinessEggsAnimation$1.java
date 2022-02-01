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
      if ("HTML".equals(localAioAnimationRule.b))
      {
        if (!TextUtils.isEmpty(localAioAnimationRule.a))
        {
          localObject = paramView.getContext();
          Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
          localIntent.putExtra("url", localAioAnimationRule.a);
          ((Context)localObject).startActivity(localIntent);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[initElementPathStrategy] jump type not define: ");
        ((StringBuilder)localObject).append(localAioAnimationRule.b);
        QLog.e("BusinessEggsAnimation", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (localObject != null) {
        EggsUtil.a(null, "0X800B072", ((ChatMessage)localObject).frienduin, localAioAnimationRule);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation.1
 * JD-Core Version:    0.7.0.1
 */