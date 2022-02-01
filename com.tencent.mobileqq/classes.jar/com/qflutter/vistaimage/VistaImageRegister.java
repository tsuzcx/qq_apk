package com.qflutter.vistaimage;

import androidx.annotation.NonNull;

public class VistaImageRegister
{
  public static boolean registerScheme(@NonNull String paramString, @NonNull Class<? extends IVistaImage> paramClass)
  {
    return SchemeService.getInstance().registerScheme(paramString, paramClass);
  }
  
  public static void unregisterScheme(@NonNull String paramString)
  {
    SchemeService.getInstance().unregisterScheme(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageRegister
 * JD-Core Version:    0.7.0.1
 */