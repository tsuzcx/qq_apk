import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import java.lang.ref.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class amtq
  extends TransProcessorHandler
{
  QQAppInterface a;
  
  public amtq(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (FileMsg)paramMessage.obj;
    if ((localObject1 == null) || (((FileMsg)localObject1).commandId != 36)) {}
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
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "finish upload cmshow record" + ((FileMsg)localObject1).serverPath);
        }
        try
        {
          paramMessage = new cmd0x346.RspBody();
          paramMessage.mergeFrom(((FileMsg)localObject1).bdhExtendInfo);
          paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
          i = paramMessage.int32_ret_code.get();
          if (i != 0) {
            break;
          }
          Object localObject2 = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
          localObject1 = null;
          paramMessage = (Message)localObject1;
          if (localObject2 != null)
          {
            paramMessage = (Message)localObject1;
            if (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()) {
              paramMessage = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
            }
          }
          QLog.i("CmGameTemp_CmGameAudioManager", 1, "[uploadFile] url:" + paramMessage);
          localObject1 = (amme)this.a.getManager(QQManagerFactory.APOLLO_MANAGER);
          localObject2 = ((amme)localObject1).a();
          ((amme)localObject1).a().a(this.a.getCurrentUin(), paramMessage, ((amtm)localObject2).a);
          return;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.e("CmGameTemp_CmGameAudioManager", 0, "upload cmshow record response error e=" + paramMessage.toString());
      return;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload fail," + i);
      paramMessage = ((amme)this.a.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
    } while ((paramMessage.b == null) || (paramMessage.b.get() == null));
    ((amtr)paramMessage.b.get()).onUploadError(-1);
    return;
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload error:" + ((FileMsg)localObject1).serverPath);
    return;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "upload cmshow cancel:" + ((FileMsg)localObject1).serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */