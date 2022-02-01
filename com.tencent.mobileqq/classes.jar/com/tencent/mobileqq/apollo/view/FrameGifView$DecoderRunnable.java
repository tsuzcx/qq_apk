package com.tencent.mobileqq.apollo.view;

class FrameGifView$DecoderRunnable
  implements Runnable
{
  private int a;
  private String b;
  private String c;
  private boolean d;
  private QQFrameZipDecoder e;
  
  public void a(QQFrameZipDecoder paramQQFrameZipDecoder, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
    this.e = paramQQFrameZipDecoder;
  }
  
  public void run()
  {
    QQFrameZipDecoder localQQFrameZipDecoder = this.e;
    if (localQQFrameZipDecoder != null) {
      localQQFrameZipDecoder.a(this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */