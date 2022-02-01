package com.tencent.luggage.wxa.cb;

import com.tencent.luggage.wxa.qj.a;
import com.tencent.luggage.wxa.qj.i;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/audio/MusicPlayerHelper;", "", "()V", "isInit", "", "initMusicPlayerManager", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  private static boolean b;
  
  @JvmStatic
  public static final void a()
  {
    try
    {
      boolean bool = b;
      if (bool) {
        return;
      }
      b = true;
      i.a((a)new c.a());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.c
 * JD-Core Version:    0.7.0.1
 */