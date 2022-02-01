package com.tencent.avgame.gameroom;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class GameRoomFragment$8
  implements Runnable
{
  GameRoomFragment$8(GameRoomFragment paramGameRoomFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing())) {
      QQToast.a(this.this$0.getActivity(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.8
 * JD-Core Version:    0.7.0.1
 */