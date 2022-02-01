package com.tencent.mobileqq.activity;

public class RegisterSendUpSms$MobileRule
  implements RegisterSendUpSms.SpaceRule
{
  public boolean a(int paramInt)
  {
    return paramInt % 4 == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms.MobileRule
 * JD-Core Version:    0.7.0.1
 */