package com.tencent.mobileqq.activity.aio.tips;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AVGameStatusTipsBar$4
  implements DialogInterface.OnClickListener
{
  AVGameStatusTipsBar$4(AVGameStatusTipsBar paramAVGameStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (AvGameManager)AVGameStatusTipsBar.a(this.a).getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (paramDialogInterface != null) {
      paramDialogInterface.a(AVGameStatusTipsBar.a(this.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar.4
 * JD-Core Version:    0.7.0.1
 */