package com.tencent.luan.ioc;

public class LuanInjectService$Builder
{
  private boolean debugMode = false;
  private ClassLoader loader = null;
  
  public LuanInjectService create()
  {
    return new LuanInjectService(this, null);
  }
  
  public Builder setClassLoader(ClassLoader paramClassLoader)
  {
    this.loader = paramClassLoader;
    return this;
  }
  
  public Builder setDebugMode(boolean paramBoolean)
  {
    this.debugMode = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjectService.Builder
 * JD-Core Version:    0.7.0.1
 */