import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class autk
  implements aufa
{
  autk(autg paramautg) {}
  
  public void a(augl paramaugl)
  {
    paramaugl = ((aufe)paramaugl).a();
    if (paramaugl == null) {}
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
          } while ((TextUtils.isEmpty(paramaugl.a())) || (aunj.a(paramaugl.a()) != 0) || (!TextUtils.isEmpty(paramaugl.g())));
          paramaugl = paramaugl.a();
          if (paramaugl != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramaugl.strThumbPath)) {
          break;
        }
      } while (autg.c(this.a) == null);
      autg.d(this.a).a(String.valueOf(paramaugl.nSessionId), paramaugl.strThumbPath);
      return;
      paramaugl = autg.a(this.a).a().a(paramaugl.peerUin, paramaugl.peerType, paramaugl.msgSeq);
    } while (paramaugl == null);
    paramaugl = (MessageForDeviceSingleStruct)paramaugl;
    abyv localabyv = ((abzb)autg.b(this.a).a(49)).a();
    autg.a(this.a, localabyv.a(paramaugl, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autk
 * JD-Core Version:    0.7.0.1
 */