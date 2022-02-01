package com.tencent.mobileqq.activity.aio.tips;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class AVGameStatusTipsBar$4
  implements DialogInterface.OnClickListener
{
  AVGameStatusTipsBar$4(AVGameStatusTipsBar paramAVGameStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (IAvGameManager)AVGameStatusTipsBar.a(this.a).getRuntimeService(IAvGameManager.class, "");
    if (paramDialogInterface != null) {
      paramDialogInterface.destroyAllGameRoom(AVGameStatusTipsBar.a(this.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar.4
 * JD-Core Version:    0.7.0.1
 */