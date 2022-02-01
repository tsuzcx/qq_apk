package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;

class GameRoomChatPie$23
  extends BroadcastReceiver
{
  GameRoomChatPie$23(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(paramContext);
    }
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.23
 * JD-Core Version:    0.7.0.1
 */