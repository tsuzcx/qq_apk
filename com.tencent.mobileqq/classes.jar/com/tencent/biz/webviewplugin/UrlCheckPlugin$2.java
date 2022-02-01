package com.tencent.biz.webviewplugin;

import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class UrlCheckPlugin$2
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  UrlCheckPlugin$2(UrlCheckPlugin paramUrlCheckPlugin) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.mTAG, 2, "onSoftKeyboardToggled");
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCheatDialogShow:");
      localStringBuilder.append(this.a.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.g != null))
    {
      if (this.a.h == null) {
        return;
      }
      if ((this.a.n >= 1) && (this.a.n <= 2))
      {
        if (this.a.q) {
          return;
        }
        if (this.a.e == UrlCheckPlugin.c)
        {
          if (this.a.n == 2)
          {
            this.a.h.removeCallbacks(this.a.r);
            this.a.a();
            localObject = this.a;
            ((UrlCheckPlugin)localObject).q = true;
            ((UrlCheckPlugin)localObject).a(2131888416);
          }
        }
        else
        {
          localObject = this.a;
          ((UrlCheckPlugin)localObject).q = true;
          ((UrlCheckPlugin)localObject).a(2131888416);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin.2
 * JD-Core Version:    0.7.0.1
 */