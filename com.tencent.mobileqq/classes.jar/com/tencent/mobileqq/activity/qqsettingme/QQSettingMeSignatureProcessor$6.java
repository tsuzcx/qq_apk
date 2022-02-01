package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.QQToast;

class QQSettingMeSignatureProcessor$6
  implements IStatusListener
{
  QQSettingMeSignatureProcessor$6(QQSettingMeSignatureProcessor paramQQSettingMeSignatureProcessor) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (QQSettingMeSignatureProcessor.a(this.a))
    {
      if (paramInt != 100) {
        QQToast.a(this.a.a, 2131690781, 0).b(this.a.a.getTitleBarHeight());
      }
      this.a.g();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.6
 * JD-Core Version:    0.7.0.1
 */