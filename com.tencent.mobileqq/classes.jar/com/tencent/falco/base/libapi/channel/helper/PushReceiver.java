package com.tencent.falco.base.libapi.channel.helper;

import com.tencent.falco.base.libapi.channel.PushCallback;

public abstract interface PushReceiver
{
  public abstract PushReceiver init(int paramInt, PushCallback paramPushCallback);
  
  public abstract void unInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.helper.PushReceiver
 * JD-Core Version:    0.7.0.1
 */