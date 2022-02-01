package com.tencent.av.wtogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.qphone.base.util.QLog;

class WTogetherRealNameVideoProcessHelper$2
  implements DialogInterface.OnClickListener
{
  WTogetherRealNameVideoProcessHelper$2(WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WTogetherRealNameVideoProcessHelper.b(this.a) != null) {
      WTogetherRealNameVideoProcessHelper.b(this.a).a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click cancel.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper.2
 * JD-Core Version:    0.7.0.1
 */