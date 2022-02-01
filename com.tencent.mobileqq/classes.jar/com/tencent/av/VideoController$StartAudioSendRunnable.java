package com.tencent.av;

class VideoController$StartAudioSendRunnable
  implements Runnable
{
  int a = 5;
  long b;
  String c;
  boolean d;
  boolean e;
  
  VideoController$StartAudioSendRunnable(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramLong;
    this.c = paramString;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public void run()
  {
    this.a -= 1;
    int i;
    if (this.a > 0) {
      i = 1;
    } else {
      i = 2;
    }
    VideoController.a(VideoController.f(), this.b, "StartAudioSendRunnable", this.d, this.e, i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], mFrom[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], mEnable[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], mNotifySvr[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.StartAudioSendRunnable
 * JD-Core Version:    0.7.0.1
 */