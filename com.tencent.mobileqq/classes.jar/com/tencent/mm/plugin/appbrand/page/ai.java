package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;

class ai
  extends MutableContextWrapper
{
  public ai(Context paramContext)
  {
    super(paramContext);
  }
  
  @JavascriptInterface
  public float getPixelRatio()
  {
    return getResources().getDisplayMetrics().density;
  }
  
  @JavascriptInterface
  public float getWidth()
  {
    return (float)Math.ceil(getResources().getDisplayMetrics().widthPixels / getPixelRatio());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */