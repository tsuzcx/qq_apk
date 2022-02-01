package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GameRoomChatPie$21
  implements ActionSheet.OnButtonClickListener
{
  GameRoomChatPie$21(GameRoomChatPie paramGameRoomChatPie, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (this.a)) {
          this.c.bN();
        }
      }
      else if (this.a) {
        this.c.bO();
      } else {
        this.c.bN();
      }
    }
    else if (this.a) {
      this.c.bQ();
    } else {
      this.c.bO();
    }
    try
    {
      this.b.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.21
 * JD-Core Version:    0.7.0.1
 */