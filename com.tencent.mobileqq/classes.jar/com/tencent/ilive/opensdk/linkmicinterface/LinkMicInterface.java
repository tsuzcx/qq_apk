package com.tencent.ilive.opensdk.linkmicinterface;

public abstract interface LinkMicInterface
{
  public abstract boolean enableReceiveAudio(boolean paramBoolean);
  
  public abstract void pauseLinkMic();
  
  public abstract void release();
  
  public abstract void resumeLinkMic();
  
  public abstract void startLinkMic();
  
  public abstract void stopLinkMic();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.linkmicinterface.LinkMicInterface
 * JD-Core Version:    0.7.0.1
 */