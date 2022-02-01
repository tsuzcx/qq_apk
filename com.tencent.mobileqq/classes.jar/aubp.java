import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aubp
  implements atnf
{
  aubp(aubl paramaubl) {}
  
  public void a(atoq paramatoq)
  {
    paramatoq = ((atnj)paramatoq).a();
    if (paramatoq == null) {}
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
          } while ((TextUtils.isEmpty(paramatoq.a())) || (atvo.a(paramatoq.a()) != 0) || (!TextUtils.isEmpty(paramatoq.g())));
          paramatoq = paramatoq.a();
          if (paramatoq != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramatoq.strThumbPath)) {
          break;
        }
      } while (aubl.c(this.a) == null);
      aubl.d(this.a).a(String.valueOf(paramatoq.nSessionId), paramatoq.strThumbPath);
      return;
      paramatoq = aubl.a(this.a).a().a(paramatoq.peerUin, paramatoq.peerType, paramatoq.msgSeq);
    } while (paramatoq == null);
    paramatoq = (MessageForDeviceSingleStruct)paramatoq;
    abur localabur = ((abux)aubl.b(this.a).a(49)).a();
    aubl.a(this.a, localabur.a(paramatoq, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubp
 * JD-Core Version:    0.7.0.1
 */