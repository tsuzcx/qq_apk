package com.tencent.ilive.litepages.room.webmodule.jsmodule;

import java.util.Map;

public abstract interface ILiteModuleProvider
{
  public abstract boolean callFunction(String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void registerJsModule(BaseLiteJSModule paramBaseLiteJSModule);
  
  public abstract void removeAllJsModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.ILiteModuleProvider
 * JD-Core Version:    0.7.0.1
 */