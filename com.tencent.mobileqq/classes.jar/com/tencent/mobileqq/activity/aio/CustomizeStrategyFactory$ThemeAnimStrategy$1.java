package com.tencent.mobileqq.activity.aio;

import aerl;
import aerm;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$ThemeAnimStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$ThemeAnimStrategy$1(aerl paramaerl, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "ThemeAnimStrategy");
    }
    if ((aerl.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.templateId)))
    {
      CustomizeStrategyFactory.a().a(this.a);
      return;
    }
    String str = this.a.templateId + ".zip";
    aerl.a(this.this$0).a(str, "", new aerm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1
 * JD-Core Version:    0.7.0.1
 */