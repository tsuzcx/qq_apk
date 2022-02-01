package com.tencent.luggage.wxa.su;

import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import java.io.File;
import org.xwalk.core.Log;

public class c
  extends g
{
  public boolean C_()
  {
    return true;
  }
  
  public int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    Object localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("performInstall version ");
    localStringBuilder.append(paramc.l);
    Log.i((String)localObject, localStringBuilder.toString());
    if (d.a(paramc.y, paramc.d))
    {
      b(paramc.l, true);
      paramc = a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("performInstall ");
      ((StringBuilder)localObject).append(e());
      ((StringBuilder)localObject).append(" success");
      Log.i(paramc, ((StringBuilder)localObject).toString());
      return 0;
    }
    Log.e(a(), "performInstall failed, md5 not match");
    paramc = new File(paramc.y);
    if (paramc.exists()) {
      paramc.delete();
    }
    h.d(a(), false);
    return -1;
  }
  
  public String a()
  {
    return "FullScreenVideo";
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str = b(paramInt);
    if ((str != null) && (!str.isEmpty()))
    {
      if (!paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("xweb_fullscreen_video.js");
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("patch");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void d()
  {
    Log.i(a(), "checkVersionFiles, skip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.c
 * JD-Core Version:    0.7.0.1
 */