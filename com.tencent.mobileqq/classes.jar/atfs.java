import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atfs
  implements asrk
{
  atfs(atfo paramatfo) {}
  
  public void a(assv paramassv)
  {
    paramassv = ((asro)paramassv).a();
    if (paramassv == null) {}
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
          } while ((TextUtils.isEmpty(paramassv.a())) || (aszt.a(paramassv.a()) != 0) || (!TextUtils.isEmpty(paramassv.g())));
          paramassv = paramassv.a();
          if (paramassv != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramassv.strThumbPath)) {
          break;
        }
      } while (atfo.c(this.a) == null);
      atfo.d(this.a).a(String.valueOf(paramassv.nSessionId), paramassv.strThumbPath);
      return;
      paramassv = atfo.a(this.a).getMessageFacade().getMsgItemByUniseq(paramassv.peerUin, paramassv.peerType, paramassv.msgSeq);
    } while (paramassv == null);
    paramassv = (MessageForDeviceSingleStruct)paramassv;
    aave localaave = ((aavk)atfo.b(this.a).getBusinessHandler(49)).a();
    atfo.a(this.a, localaave.a(paramassv, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfs
 * JD-Core Version:    0.7.0.1
 */