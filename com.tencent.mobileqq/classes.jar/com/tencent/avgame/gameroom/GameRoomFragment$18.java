package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;

class GameRoomFragment$18
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$18(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {
      return;
    }
    if (paramInt == 1)
    {
      GameRoomFragment.a(this.a, true, "2");
      GameRoomFragment.b(this.a);
      return;
    }
    GameRoomFragment.a(this.a, true, "3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.18
 * JD-Core Version:    0.7.0.1
 */