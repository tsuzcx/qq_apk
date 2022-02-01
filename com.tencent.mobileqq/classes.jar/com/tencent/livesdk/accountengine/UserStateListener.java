package com.tencent.livesdk.accountengine;

public abstract interface UserStateListener
{
  public abstract void onKickoff(int paramInt, String paramString);
  
  public abstract void onTicketInvalid(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserStateListener
 * JD-Core Version:    0.7.0.1
 */