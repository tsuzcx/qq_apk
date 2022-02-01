package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeRichStatusBean;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

class QQSettingMeSignatureProcessor$4
  implements Runnable
{
  QQSettingMeSignatureProcessor$4(QQSettingMeSignatureProcessor paramQQSettingMeSignatureProcessor, QQSettingMeRichStatusBean paramQQSettingMeRichStatusBean) {}
  
  public void run()
  {
    this.a.a = QQSettingMeSignatureProcessor.a(this.this$0).b(true);
    this.a.b = QQSettingMeSignatureProcessor.a(this.this$0).a(this.a.a.actionId, 200);
    this.this$0.i.postValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.4
 * JD-Core Version:    0.7.0.1
 */