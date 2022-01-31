package com.qq.wx.voice.recognizer;

public class InnerAudioList
{
  private a[] a = new a[4096];
  private volatile int b = 0;
  private volatile int c = 0;
  
  protected InnerAudioList()
  {
    for (;;)
    {
      if (i >= 4096) {
        return;
      }
      this.a[i] = new a(null, InnerAudioState.stop);
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
  
  protected final boolean a(a parama)
  {
    if (a(this.c) == this.b) {
      return false;
    }
    this.a[this.c] = parama;
    this.c = a(this.c);
    return true;
  }
  
  protected final a b()
  {
    if (this.b == this.c) {
      return null;
    }
    a locala = this.a[this.b];
    this.b = a(this.b);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerAudioList
 * JD-Core Version:    0.7.0.1
 */