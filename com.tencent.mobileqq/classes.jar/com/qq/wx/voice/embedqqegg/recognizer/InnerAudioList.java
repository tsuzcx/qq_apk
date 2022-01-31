package com.qq.wx.voice.embedqqegg.recognizer;

public class InnerAudioList
{
  private b[] a = new b[4096];
  private volatile int b = 0;
  private volatile int c = 0;
  
  protected InnerAudioList()
  {
    for (;;)
    {
      if (i >= 4096) {
        return;
      }
      this.a[i] = new b(null, InnerAudioState.stop);
      i += 1;
    }
  }
  
  private static int a(int paramInt)
  {
    int i = paramInt + 1;
    paramInt = i;
    if (i == 4096) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  protected final void a()
  {
    this.b = 0;
    this.c = 0;
  }
  
  protected final boolean a(b paramb)
  {
    if (a(this.c) == this.b) {
      return false;
    }
    this.a[this.c] = paramb;
    this.c = a(this.c);
    return true;
  }
  
  protected final b b()
  {
    if (this.b == this.c) {
      return null;
    }
    b localb = this.a[this.b];
    this.b = a(this.b);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.InnerAudioList
 * JD-Core Version:    0.7.0.1
 */