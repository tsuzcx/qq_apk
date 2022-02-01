package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;

class QQUiModule$1
  implements Runnable
{
  QQUiModule$1(QQUiModule paramQQUiModule, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0.getActivity();
    QBaseFragment localQBaseFragment = this.this$0.getFragment();
    if ((localObject != null) && (localQBaseFragment != null))
    {
      localObject = localQBaseFragment.getArguments().getBundle("params");
      if (localObject != null) {
        ((Bundle)localObject).putBoolean("isStatusBarDarkFont", this.val$isDarkFont);
      }
      if (localQBaseFragment.getUserVisibleHint()) {
        FlymeOSStatusBarFontUtils.a(this.this$0.getActivity(), this.val$isDarkFont);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.1
 * JD-Core Version:    0.7.0.1
 */