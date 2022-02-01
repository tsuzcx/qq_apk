import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class amzu
  extends beyf
{
  QQAppInterface a;
  
  public amzu(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (bete)paramMessage.obj;
    if ((localObject == null) || (((bete)localObject).c != 36)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 1002: 
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CmGameTemp_CmGameAudioManager", 0, "start upload cmshow record");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "finish upload cmshow record" + ((bete)localObject).g);
        }
        try
        {
          paramMessage = new cmd0x346.RspBody();
          paramMessage.mergeFrom(((bete)localObject).a);
          paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
          i = paramMessage.int32_ret_code.get();
          if (i != 0) {
            break;
          }
          paramMessage = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
          if ((paramMessage != null) && (paramMessage.str_download_url.has())) {}
          paramMessage = paramMessage.str_download_url.get();
          QLog.i("CmGameTemp_CmGameAudioManager", 1, "[uploadFile] url:" + paramMessage);
          localObject = (amsx)this.a.getManager(153);
          amzq localamzq = ((amsx)localObject).a();
          ((amsx)localObject).a().a(this.a.c(), paramMessage, localamzq.a);
          return;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.e("CmGameTemp_CmGameAudioManager", 0, "upload cmshow record response error e=" + paramMessage.toString());
      return;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload fail," + i);
      paramMessage = ((amsx)this.a.getManager(153)).a();
    } while ((paramMessage.b == null) || (paramMessage.b.get() == null));
    ((amzv)paramMessage.b.get()).a(-1);
    return;
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload error:" + ((bete)localObject).g);
    return;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "upload cmshow cancel:" + ((bete)localObject).g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzu
 * JD-Core Version:    0.7.0.1
 */