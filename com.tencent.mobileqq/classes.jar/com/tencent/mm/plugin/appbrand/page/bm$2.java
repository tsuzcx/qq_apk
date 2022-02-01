package com.tencent.mm.plugin.appbrand.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.export.external.extension.proxy.a;

class bm$2
  extends a
{
  bm$2(bm parambm) {}
  
  public void computeScroll(View paramView)
  {
    bm.g(this.a).a(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return bm.g(this.a).b(paramMotionEvent, paramView);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean)
  {
    bm.a(this.a, paramBoolean);
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return bm.g(this.a).c(paramMotionEvent, paramView);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (!af.c(paramString))
    {
      if (paramBundle == null) {
        return null;
      }
      o.d("Luggage.XWebViewImpl", "onMiscCallBack method = %s", new Object[] { paramString });
      if ("onJavascriptCloseWindow".equals(paramString)) {
        return Boolean.valueOf(true);
      }
    }
    return null;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    bm.g(this.a).a(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    bm.g(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    return WebView.getUsingTbsCoreVersion(this.a.getContext()) < 43011;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return bm.g(this.a).a(paramMotionEvent, paramView);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return bm.g(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    ad localad = bm.h(this.a);
    boolean bool2 = false;
    if (localad == null) {
      return false;
    }
    boolean bool3 = bm.h(this.a).a();
    if ((bool3) && (!bm.i(this.a))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o.d("Luggage.XWebViewImpl", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!bm.i(this.a)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.2
 * JD-Core Version:    0.7.0.1
 */