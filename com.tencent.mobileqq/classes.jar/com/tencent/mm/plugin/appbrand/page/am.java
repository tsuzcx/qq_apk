package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.Map;

public abstract interface am
  extends i, bi
{
  public abstract void a(int paramInt, long paramLong);
  
  public abstract void a(Context paramContext);
  
  public abstract void a(@Nullable Runnable paramRunnable);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract void destroy();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract int getContentHeight();
  
  public abstract View getContentView();
  
  public abstract d getFullscreenImpl();
  
  public abstract int getHeight();
  
  public abstract String getUserAgentString();
  
  public abstract int getWebScrollX();
  
  public abstract int getWebScrollY();
  
  public abstract int getWidth();
  
  public abstract View getWrapperView();
  
  public abstract void setAppBrandInfo(Map<String, String> paramMap);
  
  public abstract void setBackgroundColor(@ColorInt int paramInt);
  
  public abstract void setFullscreenImpl(d paramd);
  
  public abstract void setOnScrollChangedListener(ae paramae);
  
  public abstract void setOnTrimListener(ad paramad);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setWebViewLayoutListener(ac paramac);
  
  public abstract void setXWebKeyboardImpl(ag paramag);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */