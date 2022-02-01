import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class avar
  extends TransProcessorHandler
{
  avar(avaq paramavaq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.commandId != 76)) {}
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramMessage.what)
                {
                case 1002: 
                case 1006: 
                case 1007: 
                default: 
                  return;
                }
              } while (!QLog.isColorLevel());
              QLog.i("PicOcrManager", 2, "handleMessage start!");
              return;
            } while (!QLog.isColorLevel());
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localFileMsg.serverPath);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localFileMsg.bdhExtendInfo != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localFileMsg.bdhExtendInfo);
              paramMessage = str;
              if (localCommFileExtRsp.bytes_download_url.has()) {
                paramMessage = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
              }
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                QLog.i("PicOcrManager", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed!");
                paramMessage = str;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localFileMsg.serverPath + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          avaq.a(this.a).f = paramMessage;
          paramMessage = (avap)avaq.a(this.a).getBusinessHandler(BusinessHandlerFactory.PIC_NEW_OCR_HANDLER);
        } while (paramMessage == null);
        paramMessage.a(avaq.a(this.a).f, avaq.a(this.a).jdField_b_of_type_Long, avaq.a(this.a).d, avaq.a(this.a).e, avaq.a(this.a).jdField_a_of_type_Int, (int)avaq.a(this.a).jdField_a_of_type_Long, avaq.a(this.a).jdField_b_of_type_Int, avaq.a(this.a).c, avaq.a(this.a).jdField_a_of_type_Boolean, avaq.a(this.a).jdField_a_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localFileMsg.serverPath);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localFileMsg.serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avar
 * JD-Core Version:    0.7.0.1
 */