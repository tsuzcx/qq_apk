package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$PanelStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$PanelStrategy$1(CustomizeStrategyFactory.PanelStrategy paramPanelStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager == null) || (TextUtils.isEmpty(this.a.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager.a("redPackPanel", "https://i.gtimg.cn/channel/imglib/201803/", new String[] { "themeInfo", "prefix" });
      str = str + this.a.templateId + ".png";
      this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService.getFilePath(str, new CustomizeStrategyFactory.PanelStrategy.1.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1
 * JD-Core Version:    0.7.0.1
 */