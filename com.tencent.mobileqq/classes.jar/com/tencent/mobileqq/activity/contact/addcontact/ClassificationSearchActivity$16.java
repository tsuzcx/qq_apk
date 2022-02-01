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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramMessage = (List)paramMessage.obj;
      this.a.a(paramMessage, false);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.16
 * JD-Core Version:    0.7.0.1
 */