package com.tencent.avgame.gameroom;

import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$15
  implements Runnable
{
  GameRoomFragment$15(GameRoomFragment paramGameRoomFragment, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDialogTip content:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
      if ((GameRoomFragment.h(this.this$0) != null) && (GameRoomFragment.h(this.this$0).isShowing())) {
        GameRoomFragment.h(this.this$0).dismiss();
      }
      localObject = this.this$0;
      GameRoomFragment.a((GameRoomFragment)localObject, DialogUtil.a(((GameRoomFragment)localObject).getActivity(), 0, null, this.a, this.b, this.c, null, new GameRoomFragment.15.1(this), new GameRoomFragment.15.2(this), new GameRoomFragment.15.3(this)));
      GameRoomFragment.h(this.this$0).setCancelable(this.g);
      GameRoomFragment.h(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.15
 * JD-Core Version:    0.7.0.1
 */