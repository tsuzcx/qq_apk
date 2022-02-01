package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PokeEmoItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  PokeEmoItemBuilder$2(PokeEmoItemBuilder paramPokeEmoItemBuilder, MessageForPokeEmo paramMessageForPokeEmo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.c < 500L) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder;
      paramView.c = l;
      ChatActivityFacade.b(paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPokeEmo.uniseq);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */