package com.tencent.ark;

public abstract interface ark$ApplicationCallback
{
  public abstract void AppCreate(ark.Application paramApplication);
  
  public abstract void AppDestroy(ark.Application paramApplication);
  
  public abstract boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString);
  
  public abstract void OutputScriptError(String paramString1, String paramString2);
  
  public abstract void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ark.ApplicationCallback
 * JD-Core Version:    0.7.0.1
 */