package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Intent;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;

@API
public abstract interface RunningPlugin
{
  @API
  public abstract ProgressFuture startInitActivity(Intent paramIntent);
  
  @API
  public abstract ProgressFuture startLauncherActivity(Intent paramIntent);
  
  @API
  public abstract void unload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.RunningPlugin
 * JD-Core Version:    0.7.0.1
 */