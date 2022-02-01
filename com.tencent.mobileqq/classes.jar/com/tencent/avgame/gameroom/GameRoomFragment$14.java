package com.tencent.avgame.gameroom;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$14
  implements Runnable
{
  GameRoomFragment$14(GameRoomFragment paramGameRoomFragment, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.getQBaseActivity() != null) && (!this.this$0.getQBaseActivity().isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDialogTip content:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
      if ((GameRoomFragment.a(this.this$0) != null) && (GameRoomFragment.a(this.this$0).isShowing())) {
        GameRoomFragment.a(this.this$0).dismiss();
      }
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
        localObject = null;
      } else {
        localObject = new GameRoomFragment.14.1(this);
      }
      GameRoomFragment localGameRoomFragment = this.this$0;
      GameRoomFragment.a(localGameRoomFragment, DialogUtil.a(localGameRoomFragment.getQBaseActivity(), 230, null, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, (DialogInterface.OnClickListener)localObject, new GameRoomFragment.14.2(this)));
      GameRoomFragment.a(this.this$0).setCancelable(this.jdField_a_of_type_Boolean);
      GameRoomFragment.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.14
 * JD-Core Version:    0.7.0.1
 */