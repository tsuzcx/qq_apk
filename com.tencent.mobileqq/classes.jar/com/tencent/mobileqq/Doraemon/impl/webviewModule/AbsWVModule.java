package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;

public abstract class AbsWVModule
  extends DoraemonAPIModule
{
  protected AbsWVModule.WebViewRuntimeCompat b;
  
  protected void a()
  {
    this.b = new AbsWVModule.WebViewRuntimeCompat(this.a.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webviewModule.AbsWVModule
 * JD-Core Version:    0.7.0.1
 */