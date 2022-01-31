package com.tencent.ark;

class ArkVsync$CallbackItem
{
  ArkVsync.ArkFrameCallback callback;
  boolean isCallbacking = false;
  String queueKey;
  
  ArkVsync$CallbackItem(String paramString, ArkVsync.ArkFrameCallback paramArkFrameCallback)
  {
    this.queueKey = paramString;
    this.callback = paramArkFrameCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.CallbackItem
 * JD-Core Version:    0.7.0.1
 */