package com.tencent.avgame.gameroom;

import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$13
  implements Runnable
{
  GameRoomFragment$13(GameRoomFragment paramGameRoomFragment, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      QLog.d("GameRoomFragment", 2, "showDialogTip content:" + this.jdField_a_of_type_JavaLangString);
      if ((GameRoomFragment.a(this.this$0) != null) && (GameRoomFragment.a(this.this$0).isShowing())) {
        GameRoomFragment.a(this.this$0).dismiss();
      }
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        break label161;
      }
    }
    label161:
    for (Object localObject = null;; localObject = new GameRoomFragment.13.1(this))
    {
      GameRoomFragment.a(this.this$0, DialogUtil.a(this.this$0.getActivity(), 230, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, (DialogInterface.OnClickListener)localObject, new GameRoomFragment.13.2(this)));
      GameRoomFragment.a(this.this$0).setCancelable(this.jdField_a_of_type_Boolean);
      GameRoomFragment.a(this.this$0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.13
 * JD-Core Version:    0.7.0.1
 */