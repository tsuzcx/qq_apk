package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CardHandler$CardTransProcessorHandler
  extends TransProcessorHandler
{
  WeakReference<CardHandler.CoverTransCallback> a;
  
  public CardHandler$CardTransProcessorHandler(CardHandler.CoverTransCallback paramCoverTransCallback)
  {
    this.a = new WeakReference(paramCoverTransCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if (((FileMsg)localObject).fileType == 35) {
      switch (paramMessage.what)
      {
      default: 
      case 1004: 
      case 1005: 
        paramMessage = this.a;
        if ((paramMessage != null) && (paramMessage.get() != null))
        {
          ((CardHandler.CoverTransCallback)this.a.get()).a(((FileMsg)localObject).errorCode);
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
          return;
        }
        break;
      case 1003: 
        paramMessage = ((FileMsg)localObject).bdhExtendInfo;
        localObject = this.a;
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          ((CardHandler.CoverTransCallback)this.a.get()).b(paramMessage);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */