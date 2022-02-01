import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class avck
  implements azrg
{
  avck(avcj paramavcj) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh)
  {
    if (paramazrh != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramazrh);
    }
  }
  
  public void b(azrh paramazrh)
  {
    String str2 = avcj.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (avcj.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!avcj.b(this.a)) {
        break label167;
      }
      str1 = "1";
      label61:
      localHashMap.put("param_is_first_show", str1);
      if (str2 != null) {
        break label174;
      }
      str1 = "";
      label80:
      avcw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramazrh));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramazrh, ", isTimeOut=", Boolean.valueOf(avcj.a(this.a)), ", isFirstShow =", Boolean.valueOf(avcj.b(this.a)) });
      if (avcj.b(this.a)) {
        break label181;
      }
    }
    label167:
    label174:
    label181:
    do
    {
      do
      {
        return;
        str1 = "0";
        break;
        str1 = "0";
        break label61;
        str1 = str2;
        break label80;
      } while (avcj.a(this.a));
      i = paramazrh.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramazrh = (String[])paramazrh.jdField_a_of_type_JavaLangObject;
        if ((paramazrh != null) && (paramazrh.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramazrh[0] + " ," + paramazrh[1]);
          avcj.a(this.a, avcj.a(this.a), paramazrh[0], paramazrh[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramazrh.b;
    boolean bool = ForwardUtils.a(avcj.a(this.a));
    paramazrh = (String[])paramazrh.jdField_a_of_type_JavaLangObject;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramazrh != null) && (paramazrh.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramazrh[0] + " ," + paramazrh[1]);
      avcj.a(this.a, avcj.a(this.a), paramazrh[0], paramazrh[1]);
      return;
    }
    avcj.a(this.a, avcj.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avck
 * JD-Core Version:    0.7.0.1
 */