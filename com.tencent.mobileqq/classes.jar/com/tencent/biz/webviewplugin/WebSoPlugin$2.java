package com.tencent.biz.webviewplugin;

import aadt;
import android.app.Activity;
import bgve;
import bgzd;

public class WebSoPlugin$2
  implements Runnable
{
  public WebSoPlugin$2(aadt paramaadt, String paramString) {}
  
  public void run()
  {
    if ((bgzd.c(this.a)) && (this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null)) {
      this.this$0.mRuntime.a().runOnUiThread(new WebSoPlugin.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.2
 * JD-Core Version:    0.7.0.1
 */