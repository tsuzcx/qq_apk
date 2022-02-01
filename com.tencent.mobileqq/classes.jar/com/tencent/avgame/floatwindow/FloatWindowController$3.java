package com.tencent.avgame.floatwindow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.ui.IAVGameRootContainer;

class FloatWindowController$3
  implements DialogInterface.OnClickListener
{
  FloatWindowController$3(FloatWindowController paramFloatWindowController, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.isFinishing())
    {
      Activity localActivity = this.a;
      if ((localActivity instanceof IAVGameRootContainer))
      {
        ((IAVGameRootContainer)localActivity).notifyExitGamed();
        IGameEngine.I().w();
        IGameEngine.I().a(false, 1);
        this.a.finish();
        return;
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.3
 * JD-Core Version:    0.7.0.1
 */