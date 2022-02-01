package com.tencent.mobileqq.activity.qqsettingme;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

class QQSettingMeSignatureProcessor$7
  implements IIconListener
{
  QQSettingMeSignatureProcessor$7(QQSettingMeSignatureProcessor paramQQSettingMeSignatureProcessor) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((QQSettingMeSignatureProcessor.b(this.a)) && (paramBitmap != null) && (QQSettingMeSignatureProcessor.a(this.a).c().actionId == paramInt1) && (paramInt2 == 200)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.7
 * JD-Core Version:    0.7.0.1
 */