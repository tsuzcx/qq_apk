package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhoneFrameActivity$1
  implements View.OnClickListener
{
  PhoneFrameActivity$1(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    ForwardBaseOption localForwardBaseOption = this.a.a.a();
    if (localForwardBaseOption != null) {
      localForwardBaseOption.a(false);
    }
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity.1
 * JD-Core Version:    0.7.0.1
 */