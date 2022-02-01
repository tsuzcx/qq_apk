package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class RegisterActivity$12
  extends Handler
{
  RegisterActivity$12(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.c();
    switch (paramMessage.what)
    {
    case 0: 
    default: 
    case 8: 
      paramMessage = this.a;
      paramMessage.a = 3;
      paramMessage.a();
      return;
    case 7: 
      this.a.a(paramMessage.getData().getString("telNum"), paramMessage.getData().getString("msg"));
      return;
    case 6: 
      paramMessage = paramMessage.getData().getString("url");
      this.a.a(paramMessage);
      return;
    case 5: 
      if (this.a.c != null)
      {
        Toast.makeText(this.a.getApplicationContext(), this.a.c, 1).show();
        this.a.c = null;
        return;
      }
      break;
    case 4: 
      this.a.b();
      return;
    case 3: 
      this.a.d();
      return;
    case 1: 
      paramMessage = this.a;
      paramMessage.a = ((byte)(paramMessage.a + 1));
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.12
 * JD-Core Version:    0.7.0.1
 */