package com.tencent.maxvideo.mediadevice;

class AVCodec$1
  implements Runnable
{
  public void run()
  {
    try
    {
      AVCodec.getCallbackMethods();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AVCodec.1
 * JD-Core Version:    0.7.0.1
 */