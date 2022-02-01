package com.tencent.mobileqq.activity.aio.coreui.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FunBtnUI$1
  implements View.OnClickListener
{
  FunBtnUI$1(FunBtnUI paramFunBtnUI) {}
  
  public void onClick(View paramView)
  {
    FunBtnUI.a(this.a).p().a().a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI.1
 * JD-Core Version:    0.7.0.1
 */