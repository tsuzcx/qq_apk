import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class arfv
  implements arei
{
  arfv(arfr paramarfr) {}
  
  public void a(argc paramargc)
  {
    paramargc = ((arem)paramargc).a();
    if (paramargc == null) {}
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
          } while ((TextUtils.isEmpty(paramargc.a())) || (arni.a(paramargc.a()) != 0) || (!TextUtils.isEmpty(paramargc.g())));
          paramargc = paramargc.a();
          if (paramargc != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramargc.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Arge == null);
      this.a.jdField_a_of_type_Arge.a(String.valueOf(paramargc.nSessionId), paramargc.strThumbPath);
      return;
      paramargc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramargc.peerUin, paramargc.peerType, paramargc.msgSeq);
    } while (paramargc == null);
    paramargc = (MessageForDeviceSingleStruct)paramargc;
    zte localzte = ((ztk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    arfr.a(this.a, localzte.a(paramargc, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfv
 * JD-Core Version:    0.7.0.1
 */