package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class OuterInterceptManager$1
  implements Runnable
{
  OuterInterceptManager$1(Activity paramActivity, OuterInterceptManager.OnInterceptDialogClickListener paramOnInterceptDialogClickListener) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, "正在离开QQ，前往“腾讯微视”", 2131887648, 2131892267, new OuterInterceptManager.1.1(this), new OuterInterceptManager.1.2(this));
    localQQCustomDialog.setOnCancelListener(new OuterInterceptManager.1.3(this));
    localQQCustomDialog.setCanceledOnTouchOutside(true);
    localQQCustomDialog.show();
    OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = this.b;
    if (localOnInterceptDialogClickListener != null) {
      localOnInterceptDialogClickListener.a(localQQCustomDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1
 * JD-Core Version:    0.7.0.1
 */