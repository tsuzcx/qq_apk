package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

class QQSettingMe$27
  implements IIconListener
{
  QQSettingMe$27(QQSettingMe paramQQSettingMe) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.c) && (paramBitmap != null) && (QQSettingMe.a(this.a).a().actionId == paramInt1) && (paramInt2 == 200)) {
      this.a.y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.27
 * JD-Core Version:    0.7.0.1
 */