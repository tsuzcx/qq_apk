import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aovg
  implements aott
{
  aovg(aovc paramaovc) {}
  
  public void a(aovl paramaovl)
  {
    paramaovl = ((aotx)paramaovl).a();
    if (paramaovl == null) {}
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
          } while ((TextUtils.isEmpty(paramaovl.a())) || (apck.a(paramaovl.a()) != 0) || (!TextUtils.isEmpty(paramaovl.g())));
          paramaovl = paramaovl.a();
          if (paramaovl != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramaovl.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Aovn == null);
      this.a.jdField_a_of_type_Aovn.a(String.valueOf(paramaovl.nSessionId), paramaovl.strThumbPath);
      return;
      paramaovl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaovl.peerUin, paramaovl.peerType, paramaovl.msgSeq);
    } while (paramaovl == null);
    paramaovl = (MessageForDeviceSingleStruct)paramaovl;
    xvk localxvk = ((xvq)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    aovc.a(this.a, localxvk.a(paramaovl, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aovg
 * JD-Core Version:    0.7.0.1
 */