package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.util.QLog;

class GameRoomChatPie$16$1
  implements Runnable
{
  GameRoomChatPie$16$1(GameRoomChatPie.16 param16) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.this$0.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPlugin! hasDestory = ");
      localStringBuilder.append(this.a.this$0.B);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!this.a.this$0.B) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView != null))
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
      GameRoomChatPie.a(this.a.this$0).removeView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a((ViewGroup)this.a.this$0.g);
      this.a.this$0.b(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */