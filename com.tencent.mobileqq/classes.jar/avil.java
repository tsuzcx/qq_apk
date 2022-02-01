import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class avil
  extends beyf
{
  avil(avik paramavik, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.c != 76)) {}
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
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localbete.g);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localbete.a != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localbete.a);
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
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localbete.g + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          avik.a(this.a).f = paramMessage;
          paramMessage = (avij)avik.a(this.a).a(170);
        } while (paramMessage == null);
        paramMessage.a(avik.a(this.a).f, avik.a(this.a).jdField_b_of_type_Long, avik.a(this.a).d, avik.a(this.a).e, avik.a(this.a).jdField_a_of_type_Int, (int)avik.a(this.a).jdField_a_of_type_Long, avik.a(this.a).jdField_b_of_type_Int, avik.a(this.a).c, avik.a(this.a).jdField_a_of_type_Boolean, avik.a(this.a).jdField_a_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localbete.g);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localbete.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avil
 * JD-Core Version:    0.7.0.1
 */