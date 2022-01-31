package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config;

import ahfo;
import com.tencent.qphone.base.util.QLog;

public class SpringFestivalRedpacketConfigManager$1
  implements Runnable
{
  public SpringFestivalRedpacketConfigManager$1(ahfo paramahfo) {}
  
  public void run()
  {
    try
    {
      SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = this.this$0.a();
      if (localSpringFestivalRedpacketConfBean == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "startCheckHtmlOfflinePackage springFestivalRedpacketConfBean is empty!");
        }
      }
      else
      {
        ahfo.a(this.this$0, localSpringFestivalRedpacketConfBean.htmlOfflineCheckConfig, this.this$0.b(), this.this$0.a());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfigManager", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfigManager.1
 * JD-Core Version:    0.7.0.1
 */