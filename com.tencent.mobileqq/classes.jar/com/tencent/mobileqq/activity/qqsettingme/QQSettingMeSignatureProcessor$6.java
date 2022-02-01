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
    if (QQSettingMeSignatureProcessor.b(this.a))
    {
      if (paramInt != 100) {
        QQToast.makeText(this.a.d, 2131887703, 0).show(this.a.d.getTitleBarHeight());
      }
      this.a.i();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.6
 * JD-Core Version:    0.7.0.1
 */