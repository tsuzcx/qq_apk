package com.tencent.avcore.engine.dav;

import com.tencent.avcore.engine.IAVAdapter;

public abstract interface IDavAdapter
  extends IAVAdapter
{
  public abstract String getCustomInfo(long paramLong, String paramString);
  
  public abstract void initClientLogReport();
  
  public abstract void initConfig();
  
  public abstract void loadLibrary();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.dav.IDavAdapter
 * JD-Core Version:    0.7.0.1
 */