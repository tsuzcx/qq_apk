package com.tencent.mobileqq.activity;

import android.widget.Toast;
import mqq.observer.AccountObserver;

class QuickLoginActivity$2
  extends AccountObserver
{
  QuickLoginActivity$2(QuickLoginActivity paramQuickLoginActivity) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    Toast.makeText(this.a.getApplicationContext(), "login failure! check you qq and password!", 0).show();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Toast.makeText(this.a.getApplicationContext(), "login suc", 0).show();
  }
  
  protected void onLoginTimeout(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login outtime", 0).show();
  }
  
  protected void onUserCancel(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login cancel", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QuickLoginActivity.2
 * JD-Core Version:    0.7.0.1
 */