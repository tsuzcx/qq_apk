import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aujz
  implements atvr
{
  aujz(aujv paramaujv) {}
  
  public void a(atxc paramatxc)
  {
    paramatxc = ((atvv)paramatxc).a();
    if (paramatxc == null) {}
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
          } while ((TextUtils.isEmpty(paramatxc.a())) || (auea.a(paramatxc.a()) != 0) || (!TextUtils.isEmpty(paramatxc.g())));
          paramatxc = paramatxc.a();
          if (paramatxc != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramatxc.strThumbPath)) {
          break;
        }
      } while (aujv.c(this.a) == null);
      aujv.d(this.a).a(String.valueOf(paramatxc.nSessionId), paramatxc.strThumbPath);
      return;
      paramatxc = aujv.a(this.a).getMessageFacade().getMsgItemByUniseq(paramatxc.peerUin, paramatxc.peerType, paramatxc.msgSeq);
    } while (paramatxc == null);
    paramatxc = (MessageForDeviceSingleStruct)paramatxc;
    abkq localabkq = ((abkw)aujv.b(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
    aujv.a(this.a, localabkq.a(paramatxc, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujz
 * JD-Core Version:    0.7.0.1
 */