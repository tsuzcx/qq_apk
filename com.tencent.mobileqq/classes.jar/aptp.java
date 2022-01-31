import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.1;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2;
import com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.3;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aptp
  implements Manager
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aptp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.1(this));
  }
  
  public void a(anbg paramanbg)
  {
    if (paramanbg == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.2(this, paramanbg));
  }
  
  public boolean a()
  {
    anbg localanbg = anbh.a();
    if (localanbg == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_Long != 0L) && (awzw.a() - this.jdField_a_of_type_Long > localanbg.a() * 3600));
      String str1 = apue.a(localanbg.e());
      String str2 = HexUtil.bytes2HexStr(apue.d(localanbg.e()));
      if ((str2 == null) || (!str2.equalsIgnoreCase(str1))) {
        break;
      }
      QLog.i("FileAssistantBannerSetting", 1, "pic check is OK!");
    } while ((TextUtils.isEmpty(localanbg.c())) && (TextUtils.isEmpty(localanbg.d())));
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = awzw.a();
      ThreadManager.executeOnSubThread(new FileAssistantBannerSetting.3(this));
    }
    return true;
    a(localanbg);
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptp
 * JD-Core Version:    0.7.0.1
 */