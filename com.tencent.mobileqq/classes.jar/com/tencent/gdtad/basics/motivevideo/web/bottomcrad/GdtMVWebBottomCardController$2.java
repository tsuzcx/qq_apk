package com.tencent.gdtad.basics.motivevideo.web.bottomcrad;

import android.widget.FrameLayout;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class GdtMVWebBottomCardController$2
  extends IGdtWebViewListener
{
  GdtMVWebBottomCardController$2(GdtMVWebBottomCardController paramGdtMVWebBottomCardController) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    this.a.o.a();
    this.a.e();
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if (this.a.n)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "onPageFinished,loadSuccess");
      this.a.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController.2
 * JD-Core Version:    0.7.0.1
 */