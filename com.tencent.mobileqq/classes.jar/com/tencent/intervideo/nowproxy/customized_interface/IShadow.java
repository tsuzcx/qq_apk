package com.tencent.intervideo.nowproxy.customized_interface;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;

public abstract interface IShadow
{
  public abstract void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback);
  
  public abstract PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean hasPluginManager();
  
  public abstract void setILoggerFactory();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.IShadow
 * JD-Core Version:    0.7.0.1
 */