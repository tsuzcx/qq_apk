package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendHelper$1
  implements View.OnClickListener
{
  AddFriendHelper$1(AddFriendHelper paramAddFriendHelper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof Integer)) && (!AIOAssist.b()))
    {
      String str = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1006) {
        str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
      }
      int i = ((Integer)localObject).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              this.a.c();
            }
          }
          else {
            this.a.b();
          }
        }
        else {
          this.a.a(str);
        }
      }
      else {
        this.a.b(str);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(i, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */