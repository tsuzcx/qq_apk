package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import java.util.List;

class ClassificationSearchActivity$16
  extends Handler
{
  ClassificationSearchActivity$16(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)paramMessage.obj;
      this.a.a(paramMessage, true);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.16
 * JD-Core Version:    0.7.0.1
 */