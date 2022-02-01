package com.tencent.comic.ui;

import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

class QQComicFragment$4
  extends WebTitleBarProxy
{
  QQComicFragment$4(QQComicFragment paramQQComicFragment, WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    super(paramWebTitleBarInterface);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(AppHelper.a());
    } else {
      i = 0;
    }
    int k = paramInt1;
    int j = paramInt2;
    if (!this.a.getUIStyleHandler().f.b) {
      if (this.a.getUIStyle().v)
      {
        k = paramInt1;
        j = paramInt2;
      }
      else
      {
        k = paramInt1;
        j = paramInt2;
        if ((QQComicFragment.b(this.a) & 1L) == 1L)
        {
          k = paramInt1;
          j = paramInt2;
          if (LiuHaiUtils.b)
          {
            j = paramInt2 - i;
            k = paramInt1 - i;
          }
        }
      }
    }
    super.a(k, j);
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
    QQComicFragment.a(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    this.b.f(paramBoolean);
    QQComicFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicFragment.4
 * JD-Core Version:    0.7.0.1
 */