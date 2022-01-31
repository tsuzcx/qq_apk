package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CardHandler$CardTransProcessorHandler
  extends TransProcessorHandler
{
  WeakReference a;
  
  public CardHandler$CardTransProcessorHandler(CardHandler.CoverTransCallback paramCoverTransCallback)
  {
    this.a = new WeakReference(paramCoverTransCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.b == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localFileMsg.a;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((CardHandler.CoverTransCallback)this.a.get()).a(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((CardHandler.CoverTransCallback)this.a.get()).m();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */