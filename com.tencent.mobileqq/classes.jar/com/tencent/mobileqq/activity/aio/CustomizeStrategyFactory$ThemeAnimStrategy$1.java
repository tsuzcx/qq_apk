package com.tencent.mobileqq.activity.aio;

import afxw;
import afxx;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$ThemeAnimStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$ThemeAnimStrategy$1(afxw paramafxw, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "ThemeAnimStrategy");
    }
    if ((afxw.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.templateId)))
    {
      CustomizeStrategyFactory.a().a(this.a);
      return;
    }
    String str = this.a.templateId + ".zip";
    afxw.a(this.this$0).a(str, "", new afxx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1
 * JD-Core Version:    0.7.0.1
 */