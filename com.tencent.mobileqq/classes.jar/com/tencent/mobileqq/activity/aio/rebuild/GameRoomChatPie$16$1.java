package com.tencent.mobileqq.activity.aio.rebuild;

import ahgc;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import bhar;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;

class GameRoomChatPie$16$1
  implements Runnable
{
  GameRoomChatPie$16$1(GameRoomChatPie.16 param16) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.tag, 2, "initPlugin! hasDestory = " + this.a.this$0.hasDestory);
    }
    if ((!this.a.this$0.hasDestory) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView != null))
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
      ahgc.a(this.a.this$0).removeView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_Bhar.a((ViewGroup)this.a.this$0.jdField_a_of_type_AndroidViewView);
      this.a.this$0.a(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */