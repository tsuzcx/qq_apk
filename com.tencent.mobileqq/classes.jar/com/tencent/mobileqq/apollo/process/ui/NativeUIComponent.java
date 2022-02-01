package com.tencent.mobileqq.apollo.process.ui;

import android.content.Context;

public abstract class NativeUIComponent
{
  abstract int a(Context paramContext);
  
  abstract String a();
  
  abstract void a();
  
  void a(String paramString1, String paramString2, NativeUIManager paramNativeUIManager)
  {
    if (("destroy".equals(paramString2)) && (paramNativeUIManager != null))
    {
      a();
      paramNativeUIManager.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.NativeUIComponent
 * JD-Core Version:    0.7.0.1
 */