package com.tencent.avcore.netchannel;

import android.os.Bundle;

public abstract interface INetChannelCallback
{
  public static final String KEY_BUF = "buffer";
  public static final String KEY_TINY_ID = "tiny_id";
  
  public abstract void receiveDeviceMsg(Bundle paramBundle);
  
  public abstract void receiveGatewayMsg(String paramString, int paramInt);
  
  public abstract void receiveMultiVideoAck(Bundle paramBundle);
  
  public abstract void receiveMultiVideoMsg(Bundle paramBundle);
  
  public abstract void receiveMultiVideoOfflineMsg(Bundle paramBundle);
  
  public abstract void receiveSharpVideoAck(Bundle paramBundle);
  
  public abstract void receiveSharpVideoMsg(Bundle paramBundle);
  
  public abstract void receiveSharpVideoOfflineMsg(Bundle paramBundle);
  
  public abstract void receiveVideoConfig(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.netchannel.INetChannelCallback
 * JD-Core Version:    0.7.0.1
 */