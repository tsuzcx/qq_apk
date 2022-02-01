import MWIFI.SCGet3rdCloudCheck;
import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class bjhl
  extends bjhw
{
  bjhl(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, aola paramaola) {}
  
  public void a(int paramInt)
  {
    if ((1 == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aola);
    }
  }
  
  public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "startCheck onGetWifiSecurityCheckInfo, result: " + paramSCGet3rdCloudCheck);
    }
    if (paramSCGet3rdCloudCheck != null)
    {
      if (paramSCGet3rdCloudCheck.delayHour > 24) {
        bjia.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramSCGet3rdCloudCheck.delayHour);
      }
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "startCheck onGetWifiSecurityCheckInfo, tips: " + paramSCGet3rdCloudCheck.tips + " tipsType: " + paramSCGet3rdCloudCheck.tipsType + " delayHour: " + paramSCGet3rdCloudCheck.delayHour + " URL: " + paramSCGet3rdCloudCheck.h5);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        Message localMessage = localMqqHandler.obtainMessage(1134063);
        localMessage.obj = paramSCGet3rdCloudCheck;
        localMqqHandler.sendMessage(localMessage);
        bjhk.b(this.jdField_a_of_type_AndroidContentContext, 398677);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhl
 * JD-Core Version:    0.7.0.1
 */