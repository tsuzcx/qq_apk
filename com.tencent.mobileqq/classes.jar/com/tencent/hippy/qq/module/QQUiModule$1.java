package com.tencent.hippy.qq.module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.mobileqq.activity.qwallet.utils.FlymeOSStatusBarFontUtils;

class QQUiModule$1
  implements Runnable
{
  QQUiModule$1(QQUiModule paramQQUiModule, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0.getActivity();
    Fragment localFragment = this.this$0.getFragment();
    if ((localObject != null) && (localFragment != null))
    {
      localObject = localFragment.getArguments().getBundle("params");
      if (localObject != null) {
        ((Bundle)localObject).putBoolean("isStatusBarDarkFont", this.val$isDarkFont);
      }
      if (localFragment.getUserVisibleHint()) {
        FlymeOSStatusBarFontUtils.a(this.this$0.getActivity(), this.val$isDarkFont);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.1
 * JD-Core Version:    0.7.0.1
 */