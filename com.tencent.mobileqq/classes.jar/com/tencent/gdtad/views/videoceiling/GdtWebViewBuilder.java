package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class GdtWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  protected Intent a;
  
  public GdtWebViewBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle)
  {
    super.b(this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
  }
  
  public final void a(AppInterface paramAppInterface)
  {
    super.b(paramAppInterface);
  }
  
  public void a(ArrayList paramArrayList)
  {
    super.a(paramArrayList);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  public void b()
  {
    super.u();
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c()
  {
    super.v();
  }
  
  public void c_()
  {
    super.y();
  }
  
  public void d()
  {
    try
    {
      super.w();
      return;
    }
    catch (Exception localException)
    {
      GdtLog.d("GdtWebViewBuilder", "getVideoComponent error", localException);
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */