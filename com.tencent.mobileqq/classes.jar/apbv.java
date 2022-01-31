import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.1;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.3;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class apbv
  implements Manager
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apbv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.1(this));
  }
  
  public void a(amlc paramamlc)
  {
    if (paramamlc == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.2(this, paramamlc));
  }
  
  public boolean a()
  {
    amlc localamlc = amld.a();
    if (localamlc == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_Long != 0L) && (awao.a() - this.jdField_a_of_type_Long > localamlc.a() * 3600));
      String str1 = apck.a(localamlc.e());
      String str2 = HexUtil.bytes2HexStr(apck.d(localamlc.e()));
      if ((str2 == null) || (!str2.equalsIgnoreCase(str1))) {
        break;
      }
      QLog.i("FileAssistantBannerSetting", 1, "pic check is OK!");
    } while ((TextUtils.isEmpty(localamlc.c())) && (TextUtils.isEmpty(localamlc.d())));
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = awao.a();
      ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.3(this));
    }
    return true;
    a(localamlc);
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbv
 * JD-Core Version:    0.7.0.1
 */