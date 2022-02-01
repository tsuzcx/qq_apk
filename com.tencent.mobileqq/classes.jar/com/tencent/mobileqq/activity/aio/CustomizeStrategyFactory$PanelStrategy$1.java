package com.tencent.mobileqq.activity.aio;

import aghk;
import aghl;
import alao;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$PanelStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$PanelStrategy$1(aghk paramaghk, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager == null) || (this.this$0.jdField_a_of_type_Alao == null) || (TextUtils.isEmpty(this.a.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.this$0.jdField_a_of_type_Alao.a("redPackPanel", "https://i.gtimg.cn/channel/imglib/201803/", new String[] { "themeInfo", "prefix" });
      str = str + this.a.templateId + ".png";
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.b(str, new aghl(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1
 * JD-Core Version:    0.7.0.1
 */