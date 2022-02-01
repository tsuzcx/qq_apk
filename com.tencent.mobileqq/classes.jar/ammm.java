import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ammm
  extends TransProcessorHandler
{
  ammm(amme paramamme, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24)) {}
    for (;;)
    {
      return;
      if (localFileMsg.commandId == 79) {
        switch (paramMessage.what)
        {
        case 1002: 
        default: 
          return;
        case 1001: 
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 0, "start upload cmshow3D face data");
            return;
          }
          break;
        case 1003: 
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "finish upload cmshow3D face data" + localFileMsg.serverPath);
          }
          paramMessage = new Bdh_extinfo.UploadPicExtInfo();
          try
          {
            paramMessage.mergeFrom(localFileMsg.bdhExtendInfo);
            paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
            if ((paramMessage != null) && (amme.a(this.a) != null) && (amme.a(this.a).get() != null)) {
              ((ammy)amme.a(this.a).get()).onSuccess(paramMessage);
            }
            if (this.a.a != null)
            {
              this.a.a.removeHandle(this);
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
      }
    }
    QLog.e("ApolloManager", 1, "[mTransProcessorHandler] upload cmshow3D face data error:" + localFileMsg.serverPath);
    ((ammy)amme.a(this.a).get()).onFailed();
    return;
    QLog.i("ApolloManager", 1, "upload cmshow cmshow3D face data cancel:" + localFileMsg.serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammm
 * JD-Core Version:    0.7.0.1
 */