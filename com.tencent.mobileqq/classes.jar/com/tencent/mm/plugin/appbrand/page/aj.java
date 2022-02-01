package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import java.net.URL;
import java.util.Map;

public class aj
  implements am
{
  private ViewGroup a;
  private ViewGroup b;
  
  public <T extends j> T a(Class<T> paramClass)
  {
    return null;
  }
  
  public void a(int paramInt, long paramLong) {}
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new FrameLayout(paramContext);
    }
    if (this.b == null) {
      this.b = new FrameLayout(paramContext);
    }
  }
  
  public void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    return false;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void destroy()
  {
    this.a = null;
    this.b = null;
  }
  
  public void e() {}
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public void f() {}
  
  public void g() {}
  
  public int getContentHeight()
  {
    return 0;
  }
  
  public View getContentView()
  {
    return this.b;
  }
  
  public d getFullscreenImpl()
  {
    return null;
  }
  
  public int getHeight()
  {
    return 0;
  }
  
  public String getUserAgentString()
  {
    return "MiniGame";
  }
  
  public int getWebScrollX()
  {
    return 0;
  }
  
  public int getWebScrollY()
  {
    return 0;
  }
  
  public int getWidth()
  {
    return 0;
  }
  
  public View getWrapperView()
  {
    return this.a;
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setFullscreenImpl(d paramd) {}
  
  public void setJsExceptionHandler(h paramh) {}
  
  public void setOnScrollChangedListener(ae paramae) {}
  
  public void setOnTrimListener(ad paramad) {}
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public void setWebViewLayoutListener(ac paramac) {}
  
  public void setXWebKeyboardImpl(ag paramag) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */