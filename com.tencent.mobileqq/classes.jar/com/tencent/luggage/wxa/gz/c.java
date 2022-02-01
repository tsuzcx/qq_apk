package com.tencent.luggage.wxa.gz;

import com.tencent.luggage.wxa.qy.b;

public final class c
  extends b
{
  public c.a a = new c.a();
  
  public c()
  {
    this(null);
  }
  
  public c(Runnable paramRunnable)
  {
    this.d = false;
    this.c = paramRunnable;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "play";
    }
    if (paramInt == 1) {
      return "play";
    }
    if (paramInt == 2) {
      return "pause";
    }
    if (paramInt == 3) {
      return "stop";
    }
    if (paramInt == 4) {
      return "error";
    }
    if (paramInt == 5) {
      return "ended";
    }
    if (paramInt == 6) {
      return "seeked";
    }
    if (paramInt == 7) {
      return "canplay";
    }
    if (paramInt == 9) {
      return "waiting";
    }
    if (paramInt == 10) {
      return "seeking";
    }
    if (paramInt == 11) {
      return "real_play";
    }
    if (paramInt == 12) {
      return "mix_play_ready";
    }
    if (paramInt == 13) {
      return "preload_end";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gz.c
 * JD-Core Version:    0.7.0.1
 */