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
    if (!this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getUIStyleHandler().a.b) {
      if (this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getUIStyle().m)
      {
        k = paramInt1;
        j = paramInt2;
      }
      else
      {
        k = paramInt1;
        j = paramInt2;
        if ((QQComicFragment.a(this.jdField_a_of_type_ComTencentComicUiQQComicFragment) & 1L) == 1L)
        {
          k = paramInt1;
          j = paramInt2;
          if (LiuHaiUtils.a)
          {
            j = paramInt2 - i;
            k = paramInt1 - i;
          }
        }
      }
    }
    super.a(k, j);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebTitleBarInterface.b(paramBoolean);
    QQComicFragment.a(this.jdField_a_of_type_ComTencentComicUiQQComicFragment);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebTitleBarInterface.e(paramBoolean);
    QQComicFragment.a(this.jdField_a_of_type_ComTencentComicUiQQComicFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicFragment.4
 * JD-Core Version:    0.7.0.1
 */