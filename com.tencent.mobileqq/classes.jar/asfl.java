import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class asfl
  extends baua
{
  asfl(asfk paramasfk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.c != 76)) {}
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
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localbaoj.g);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localbaoj.a != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localbaoj.a);
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
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localbaoj.g + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          asfk.a(this.a).f = paramMessage;
          paramMessage = (asfj)asfk.a(this.a).a(170);
        } while (paramMessage == null);
        paramMessage.a(asfk.a(this.a).f, asfk.a(this.a).jdField_b_of_type_Long, asfk.a(this.a).d, asfk.a(this.a).e, asfk.a(this.a).jdField_a_of_type_Int, (int)asfk.a(this.a).jdField_a_of_type_Long, asfk.a(this.a).jdField_b_of_type_Int, asfk.a(this.a).c, asfk.a(this.a).jdField_a_of_type_Boolean, asfk.a(this.a).jdField_a_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localbaoj.g);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localbaoj.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfl
 * JD-Core Version:    0.7.0.1
 */