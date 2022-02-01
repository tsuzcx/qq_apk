package com.huawei.hms.update.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

class l$1
  extends Handler
{
  l$1(l paraml) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 101: 
      l.a(this.a, localBundle);
      return;
    case 102: 
      l.b(this.a, localBundle);
      return;
    }
    l.c(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.l.1
 * JD-Core Version:    0.7.0.1
 */