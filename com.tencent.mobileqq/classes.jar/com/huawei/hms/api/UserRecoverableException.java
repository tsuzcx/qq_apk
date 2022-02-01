package com.huawei.hms.api;

import android.content.Intent;

public class UserRecoverableException
  extends Exception
{
  private final Intent a;
  
  public UserRecoverableException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.a = paramIntent;
  }
  
  public Intent getIntent()
  {
    return new Intent(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.UserRecoverableException
 * JD-Core Version:    0.7.0.1
 */