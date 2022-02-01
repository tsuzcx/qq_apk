package com.tencent.mobileqq.Doraemon.impl.webview;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.Doraemon.manifest.D.manifest.webview_apis;
import java.util.Map;

public class WebViewDoraemonAPIManager
  extends DefaultDoraemonAPIManager
{
  protected String m;
  public boolean n;
  public String o;
  public String p;
  
  public WebViewDoraemonAPIManager(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    super(paramActivity, paramInt, paramString1);
    this.m = paramString2;
  }
  
  protected Map<String, APIConfig> d()
  {
    return D.manifest.webview_apis.a();
  }
  
  protected void e()
  {
    DefaultDoraemonAppInfoHelper.a().a(this.c, this.a, this.b, this.m, new WebViewDoraemonAPIManager.1(this));
  }
  
  public boolean j()
  {
    return this.f == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */