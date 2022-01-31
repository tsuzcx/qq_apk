import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.thirdpay.ThirdPayGate;

public class anez
  extends anfa
{
  public anez(ThirdPayGate paramThirdPayGate, PluginInterface paramPluginInterface, String paramString, long paramLong, Handler paramHandler)
  {
    super(paramThirdPayGate);
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        Bundle localBundle = ThirdPayGate.access$500(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface, this.jdField_a_of_type_JavaLangString);
        if ((localBundle == null) || (!localBundle.getBoolean("plugininfo", false)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardPayGate", 2, "install----pluginInfo is null...");
          }
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 5000L)
          {
            try
            {
              Thread.sleep(1000L);
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
            }
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardPayGate", 2, "install----pluginInfo is null. timeout.");
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4097);
        }
      }
      else
      {
        return;
      }
      int i = localInterruptedException1.getInt("pluginstate");
      float f = localInterruptedException1.getFloat("pluginprogress");
      if (QLog.isColorLevel())
      {
        QLog.d("CardPayGate", 2, "pluginState----" + i);
        QLog.d("CardPayGate", 2, "progress----" + f);
      }
      if (i == 4)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        return;
      }
      if (i != 1) {
        if (i == 2)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        else if (i == 3)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        else
        {
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 15000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CardPayGate", 2, "install----pluginInfo is not null. timeout.");
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4097);
            return;
          }
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anez
 * JD-Core Version:    0.7.0.1
 */