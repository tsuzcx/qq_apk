package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bcdp;
import bcij;
import com.tencent.smtt.sdk.WebView;
import xme;

public class QzonePlugin$2
  implements Runnable
{
  public QzonePlugin$2(xme paramxme) {}
  
  public void run()
  {
    if (xme.a(this.this$0) != null)
    {
      Object localObject = xme.a(this.this$0);
      if (this.this$0.mRuntime.a().getIntent().getExtras().getString("url") != null) {
        localObject = this.this$0.mRuntime.a().getIntent().getExtras().getString("url");
      }
      xme.a(this.this$0).loadData(new String((String)localObject).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      localObject = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof bcij))) {
        ((bcij)localObject).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin.2
 * JD-Core Version:    0.7.0.1
 */