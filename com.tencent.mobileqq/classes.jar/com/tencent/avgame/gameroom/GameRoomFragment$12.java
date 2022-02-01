package com.tencent.avgame.gameroom;

import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.widget.QQToast;

class GameRoomFragment$12
  implements Runnable
{
  GameRoomFragment$12(GameRoomFragment paramGameRoomFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getActivity() != null) {}
    for (AVGameActivity localAVGameActivity = (AVGameActivity)this.this$0.getActivity();; localAVGameActivity = null)
    {
      if ((localAVGameActivity != null) && (!localAVGameActivity.d())) {
        QQToast.a(this.this$0.getActivity(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 1).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.12
 * JD-Core Version:    0.7.0.1
 */