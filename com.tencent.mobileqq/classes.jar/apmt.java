import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apmt
  implements aplf
{
  apmt(apmp paramapmp) {}
  
  public void a(apmy paramapmy)
  {
    paramapmy = ((aplj)paramapmy).a();
    if (paramapmy == null) {}
    label12:
    do
    {
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while ((TextUtils.isEmpty(paramapmy.a())) || (apue.a(paramapmy.a()) != 0) || (!TextUtils.isEmpty(paramapmy.g())));
          paramapmy = paramapmy.a();
          if (paramapmy != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramapmy.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Apna == null);
      this.a.jdField_a_of_type_Apna.a(String.valueOf(paramapmy.nSessionId), paramapmy.strThumbPath);
      return;
      paramapmy = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapmy.peerUin, paramapmy.peerType, paramapmy.msgSeq);
    } while (paramapmy == null);
    paramapmy = (MessageForDeviceSingleStruct)paramapmy;
    yeo localyeo = ((yeu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    apmp.a(this.a, localyeo.a(paramapmy, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmt
 * JD-Core Version:    0.7.0.1
 */