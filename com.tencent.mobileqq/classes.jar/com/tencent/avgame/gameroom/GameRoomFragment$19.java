package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;

class GameRoomFragment$19
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$19(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    if (this.a.getActivity() != null)
    {
      if (this.a.getActivity().isFinishing()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.19
 * JD-Core Version:    0.7.0.1
 */