package com.tencent.biz.tribe;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

class TribeVideoPlugin$1
  implements TouchWebView.OnScrollChangedListener
{
  TribeVideoPlugin$1(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "onWebViewCreated onScrollChanged before every thing t = " + paramInt2 + " oldt = " + paramInt4);
    }
    if (TribeVideoPlugin.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "onWebViewCreated onScrollChanged t = " + paramInt2 + " oldt = " + paramInt4);
      }
      TribeVideoPlugin.a(this.a).scrollBy(0, paramInt2 - paramInt4);
      TribeVideoPlugin.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.1
 * JD-Core Version:    0.7.0.1
 */