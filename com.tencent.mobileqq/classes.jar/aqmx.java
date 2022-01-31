import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class aqmx
  extends aywb
{
  aqmx(aqmw paramaqmw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || (localayqo.c != 76)) {}
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
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localayqo.g);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localayqo.a != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localayqo.a);
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
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localayqo.g + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          aqmw.a(this.a).f = paramMessage;
          paramMessage = (aqmv)aqmw.a(this.a).a(170);
        } while (paramMessage == null);
        paramMessage.a(aqmw.a(this.a).f, aqmw.a(this.a).jdField_b_of_type_Long, aqmw.a(this.a).d, aqmw.a(this.a).e, aqmw.a(this.a).jdField_a_of_type_Int, (int)aqmw.a(this.a).jdField_a_of_type_Long, aqmw.a(this.a).jdField_b_of_type_Int, aqmw.a(this.a).c, aqmw.a(this.a).jdField_a_of_type_Boolean, aqmw.a(this.a).jdField_a_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localayqo.g);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localayqo.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmx
 * JD-Core Version:    0.7.0.1
 */