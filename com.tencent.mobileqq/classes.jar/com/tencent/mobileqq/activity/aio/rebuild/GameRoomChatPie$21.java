package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GameRoomChatPie$21
  implements ActionSheet.OnButtonClickListener
{
  GameRoomChatPie$21(GameRoomChatPie paramGameRoomChatPie, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ax();
        }
      }
      else if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ay();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ax();
      }
    }
    else if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.aA();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ay();
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.21
 * JD-Core Version:    0.7.0.1
 */