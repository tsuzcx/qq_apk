package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$8
  implements View.OnClickListener
{
  BaseChatPie$8(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    while (AIOAssist.b())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = this.a.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1006) {
      str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    int i = ((Integer)localObject).intValue();
    switch (i)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(i, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      break;
      this.a.b(str);
      continue;
      this.a.a(str);
      continue;
      this.a.m();
      continue;
      this.a.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.8
 * JD-Core Version:    0.7.0.1
 */