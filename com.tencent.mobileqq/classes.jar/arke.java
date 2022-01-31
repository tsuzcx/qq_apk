import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class arke
  implements arir
{
  arke(arka paramarka) {}
  
  public void a(arkl paramarkl)
  {
    paramarkl = ((ariv)paramarkl).a();
    if (paramarkl == null) {}
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
          } while ((TextUtils.isEmpty(paramarkl.a())) || (arrr.a(paramarkl.a()) != 0) || (!TextUtils.isEmpty(paramarkl.g())));
          paramarkl = paramarkl.a();
          if (paramarkl != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramarkl.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Arkn == null);
      this.a.jdField_a_of_type_Arkn.a(String.valueOf(paramarkl.nSessionId), paramarkl.strThumbPath);
      return;
      paramarkl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramarkl.peerUin, paramarkl.peerType, paramarkl.msgSeq);
    } while (paramarkl == null);
    paramarkl = (MessageForDeviceSingleStruct)paramarkl;
    zxt localzxt = ((zxz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    arka.a(this.a, localzxt.a(paramarkl, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arke
 * JD-Core Version:    0.7.0.1
 */