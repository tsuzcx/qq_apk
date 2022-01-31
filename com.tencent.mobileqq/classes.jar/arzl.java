import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class arzl
  implements awfy
{
  arzl(arzk paramarzk) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz)
  {
    if (paramawfz != null) {
      QLog.d("ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramawfz);
    }
  }
  
  public void b(awfz paramawfz)
  {
    String str2 = arzk.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (arzk.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!arzk.b(this.a)) {
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
      arzy.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramawfz));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramawfz, ", isTimeOut=", Boolean.valueOf(arzk.a(this.a)), ", isFirstShow =", Boolean.valueOf(arzk.b(this.a)) });
      if (arzk.b(this.a)) {
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
      } while (arzk.a(this.a));
      i = paramawfz.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramawfz = (String[])paramawfz.jdField_a_of_type_JavaLangObject;
        if ((paramawfz != null) && (paramawfz.length == 2))
        {
          QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramawfz[0] + " ," + paramawfz[1]);
          arzk.a(this.a, arzk.a(this.a), paramawfz[0], paramawfz[1]);
          return;
        }
        QLog.e("ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramawfz.b;
    boolean bool = ForwardUtils.a(arzk.a(this.a));
    paramawfz = (String[])paramawfz.jdField_a_of_type_JavaLangObject;
    QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramawfz != null) && (paramawfz.length == 2))
    {
      QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramawfz[0] + " ," + paramawfz[1]);
      arzk.a(this.a, arzk.a(this.a), paramawfz[0], paramawfz[1]);
      return;
    }
    arzk.a(this.a, arzk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzl
 * JD-Core Version:    0.7.0.1
 */