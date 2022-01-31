import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class amqt
  implements Runnable
{
  public amqt(int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int j = 0;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.comic_plugin_profile.name(), "");
    Integer[] arrayOfInteger = new Integer[7];
    int i = j;
    if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length)
    {
      i = j;
      if ((arrayOfInteger[4].intValue() & this.jdField_a_of_type_Int) != 0) {
        i = 1;
      }
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComicHelper", 2, "Skip update offline pkg. entry = " + this.jdField_a_of_type_Int);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "Do update offline pkg. entry = " + this.jdField_a_of_type_Int);
    }
    HtmlOffline.b("354", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new amqu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqt
 * JD-Core Version:    0.7.0.1
 */