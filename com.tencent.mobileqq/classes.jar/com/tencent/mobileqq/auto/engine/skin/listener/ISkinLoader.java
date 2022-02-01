package com.tencent.mobileqq.auto.engine.skin.listener;

import android.content.res.Resources;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinPkgInfo;

public abstract interface ISkinLoader
{
  public abstract void attach(ISkinUpdate paramISkinUpdate);
  
  public abstract void detach(ISkinUpdate paramISkinUpdate);
  
  public abstract String getPackageName();
  
  public abstract SkinPkgInfo getSkinResouceData();
  
  public abstract Resources getSkinResource();
  
  public abstract boolean loadSkinFile(SkinPkgInfo paramSkinPkgInfo);
  
  public abstract void notifySkinUpdate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
 * JD-Core Version:    0.7.0.1
 */