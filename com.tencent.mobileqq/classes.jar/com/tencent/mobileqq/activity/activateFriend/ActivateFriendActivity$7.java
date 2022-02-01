package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ActivateFriendActivity$7
  implements View.OnClickListener
{
  ActivateFriendActivity$7(ActivateFriendActivity paramActivateFriendActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app;
    if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {}
    for (;;)
    {
      QQNotifyHelper.a(localQQAppInterface, "remindpage_click", null, null, String.valueOf(2), String.valueOf(i));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.7
 * JD-Core Version:    0.7.0.1
 */