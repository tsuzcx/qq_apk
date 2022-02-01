package com.qflutter.superchannel;

import androidx.annotation.NonNull;

public class SuperChannelRegister
{
  public static void registerModule(@NonNull String paramString, @NonNull IModule paramIModule)
  {
    ModuleService.getInstance().registerModule(paramString, paramIModule);
  }
  
  public static void registerModuleClass(@NonNull String paramString, @NonNull Class<? extends IModule> paramClass)
  {
    ModuleService.getInstance().registerModuleClass(paramString, paramClass);
  }
  
  public static void unregisterModule(@NonNull String paramString)
  {
    ModuleService.getInstance().unregisterModule(paramString);
  }
  
  public static void unregisterModuleClass(@NonNull String paramString)
  {
    ModuleService.getInstance().unregisterModuleClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelRegister
 * JD-Core Version:    0.7.0.1
 */