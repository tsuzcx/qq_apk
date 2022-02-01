package com.tencent.av.app;

import com.tencent.avcore.util.GlStringParser;
import java.io.File;

public class DeviceCapability$CodecPlayerCallback$CodecTestInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public int e;
  public int f;
  public String g;
  
  public int a()
  {
    int i = this.a;
    if (i == 1) {
      return 2;
    }
    if (i == 4) {
      return 1;
    }
    if (i == 2) {
      return 4;
    }
    if (i == 8) {
      return 3;
    }
    return 0;
  }
  
  public String b()
  {
    GlStringParser localGlStringParser = new GlStringParser('=', ';');
    localGlStringParser.set("s_path", this.c);
    if (c())
    {
      localGlStringParser.set("i_fps", this.e);
      localGlStringParser.set("i_bitrate", this.f);
      localGlStringParser.set("s_outpath", this.g);
      File localFile = new File(this.g);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    else
    {
      localGlStringParser.set("s_expMd5", this.d);
    }
    return localGlStringParser.flatten();
  }
  
  public boolean c()
  {
    int i = this.a;
    if (i != 2)
    {
      if (i == 8) {
        return true;
      }
      if ((i != 1) && (i == 4)) {}
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapability.CodecPlayerCallback.CodecTestInfo
 * JD-Core Version:    0.7.0.1
 */