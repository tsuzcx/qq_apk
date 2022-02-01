package com.tencent.mobileqq.activity.troop.config;

import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.AbsTroopMngHandlerProcessor;
import mqq.os.MqqHandler;

public class GAudioMsgTroopMngProcessor
  extends AbsTroopMngHandlerProcessor
{
  private void e(@NonNull AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = paramAppInterface.getHandler(AVNotifyCenter.class);
    if (paramAppInterface != null)
    {
      Message localMessage = paramAppInterface.obtainMessage(10011);
      localMessage.obj = Long.valueOf(paramString);
      paramAppInterface.sendMessage(localMessage);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    e(paramAppInterface, paramString);
  }
  
  public void b(@NonNull AppInterface paramAppInterface, String paramString)
  {
    e(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.GAudioMsgTroopMngProcessor
 * JD-Core Version:    0.7.0.1
 */