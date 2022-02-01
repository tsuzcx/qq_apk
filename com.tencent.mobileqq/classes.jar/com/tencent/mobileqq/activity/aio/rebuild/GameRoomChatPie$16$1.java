package com.tencent.mobileqq.activity.aio.rebuild;

import aiay;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import bhtu;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;

class GameRoomChatPie$16$1
  implements Runnable
{
  GameRoomChatPie$16$1(GameRoomChatPie.16 param16) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.jdField_a_of_type_JavaLangString, 2, "initPlugin! hasDestory = " + this.a.this$0.M);
    }
    if ((!this.a.this$0.M) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView != null))
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
      aiay.a(this.a.this$0).removeView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_Bhtu.a((ViewGroup)this.a.this$0.n);
      this.a.this$0.e(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */