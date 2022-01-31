package com.tencent.mobileqq.apollo.game;

import aiyf;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class ApolloJSContext$1
  implements Runnable
{
  public ApolloJSContext$1(aiyf paramaiyf) {}
  
  public void run()
  {
    if (aiyf.a(this.this$0) != null)
    {
      Object localObject = aiyf.a(this.this$0).getUrl();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("urlshare.cn")) && (aiyf.a(this.this$0) != null))
      {
        localObject = aiyf.a(this.this$0).getPluginEngine();
        if (localObject != null)
        {
          localObject = ((WebViewPluginEngine)localObject).a("apolloGame");
          if ((localObject != null) && (!((WebViewPlugin)localObject).isDestroy) && ((localObject instanceof ApolloGamePlugin))) {
            ((ApolloGamePlugin)localObject).a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext.1
 * JD-Core Version:    0.7.0.1
 */