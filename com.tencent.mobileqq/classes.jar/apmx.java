import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apmx
  implements aplj
{
  apmx(apmt paramapmt) {}
  
  public void a(apnc paramapnc)
  {
    paramapnc = ((apln)paramapnc).a();
    if (paramapnc == null) {}
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
          } while ((TextUtils.isEmpty(paramapnc.a())) || (apug.a(paramapnc.a()) != 0) || (!TextUtils.isEmpty(paramapnc.g())));
          paramapnc = paramapnc.a();
          if (paramapnc != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramapnc.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Apne == null);
      this.a.jdField_a_of_type_Apne.a(String.valueOf(paramapnc.nSessionId), paramapnc.strThumbPath);
      return;
      paramapnc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapnc.peerUin, paramapnc.peerType, paramapnc.msgSeq);
    } while (paramapnc == null);
    paramapnc = (MessageForDeviceSingleStruct)paramapnc;
    yel localyel = ((yer)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    apmt.a(this.a, localyel.a(paramapnc, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmx
 * JD-Core Version:    0.7.0.1
 */