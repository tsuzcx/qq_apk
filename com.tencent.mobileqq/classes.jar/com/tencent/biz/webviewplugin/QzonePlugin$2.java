package com.tencent.biz.webviewplugin;

import aasf;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bifw;
import bikm;
import com.tencent.smtt.sdk.WebView;

public class QzonePlugin$2
  implements Runnable
{
  public QzonePlugin$2(aasf paramaasf) {}
  
  public void run()
  {
    if (aasf.a(this.this$0) != null)
    {
      Object localObject = aasf.a(this.this$0);
      if (this.this$0.mRuntime.a().getIntent().getExtras().getString("url") != null) {
        localObject = this.this$0.mRuntime.a().getIntent().getExtras().getString("url");
      }
      aasf.a(this.this$0).loadData(new String((String)localObject).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      localObject = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof bikm))) {
        ((bikm)localObject).setBottomBarVisible(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin.2
 * JD-Core Version:    0.7.0.1
 */