package com.tencent.hippy.qq.module;

import albp;
import android.os.Bundle;
import android.support.v4.app.Fragment;

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
        albp.a(this.this$0.getActivity(), this.val$isDarkFont);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.1
 * JD-Core Version:    0.7.0.1
 */