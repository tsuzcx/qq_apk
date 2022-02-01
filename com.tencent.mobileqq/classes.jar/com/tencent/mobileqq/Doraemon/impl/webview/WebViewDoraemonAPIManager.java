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
  public boolean b;
  protected String c;
  public String d;
  public String e;
  
  public WebViewDoraemonAPIManager(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    super(paramActivity, paramInt, paramString1);
    this.c = paramString2;
  }
  
  protected Map<String, APIConfig> a()
  {
    return D.manifest.webview_apis.a();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 2;
  }
  
  protected void c()
  {
    DefaultDoraemonAppInfoHelper.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.c, new WebViewDoraemonAPIManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */