package com.tencent.avgame.util;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

final class AVGameUtil$1
  implements Runnable
{
  AVGameUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    String str = this.a.getString(2131887191);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDialogTip content:");
    localStringBuilder.append(this.b);
    QLog.d("AVGameUtils", 2, localStringBuilder.toString());
    DialogUtil.a(this.a, 230, null, this.b, str, str, new AVGameUtil.1.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameUtil.1
 * JD-Core Version:    0.7.0.1
 */