package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static c a = new a.a(null);
  private static boolean b = false;
  private static boolean c = false;
  
  public static void a()
  {
    o.d("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new a.2());
    d();
  }
  
  public static void a(c paramc)
  {
    a = paramc;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = b;
      if (bool) {
        return true;
      }
      c localc = a;
      if (localc == null) {
        return false;
      }
      a.c(NativeLibs.nlog.getName());
      a.c(NativeLibs.audioCommon.getName());
      bool = a.a(NativeLibs.nlog.getName());
      if (bool)
      {
        try
        {
          b = AudioPlayerConfigure.enableNativeLog(null);
        }
        catch (Throwable localThrowable)
        {
          o.a("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
          if (!com.tencent.luggage.wxa.hg.c.b(20)) {
            break label138;
          }
        }
        b = AudioPlayerConfigure.enableNativeLog(null);
        if (b) {
          o.d("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
        }
        bool = b;
        return bool;
        label138:
        throw localThrowable;
      }
      o.d("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
      return false;
    }
    finally {}
  }
  
  private static void d()
  {
    if (b) {
      return;
    }
    if (c) {
      return;
    }
    c = true;
    com.tencent.luggage.wxa.rd.a.b(new a.3(), "audio load NLog");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.a
 * JD-Core Version:    0.7.0.1
 */