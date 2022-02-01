package com.tencent.mobileqq.apollo.makeup;

import android.view.ViewGroup;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class CmShowMakeupFragment$3$1
  implements Runnable
{
  CmShowMakeupFragment$3$1(CmShowMakeupFragment.3 param3) {}
  
  public void run()
  {
    if ((CmShowMakeupFragment.f(this.a.a) != null) && (this.a.a.getUIStyleHandler() != null) && (this.a.a.getUIStyleHandler().u != null)) {
      this.a.a.getUIStyleHandler().u.removeView(CmShowMakeupFragment.f(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.3.1
 * JD-Core Version:    0.7.0.1
 */