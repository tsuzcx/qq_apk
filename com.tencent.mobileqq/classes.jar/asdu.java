import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class asdu
  implements awkh
{
  asdu(asdt paramasdt) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki)
  {
    if (paramawki != null) {
      QLog.d("ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramawki);
    }
  }
  
  public void b(awki paramawki)
  {
    String str2 = asdt.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (asdt.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!asdt.b(this.a)) {
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
      aseh.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramawki));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramawki, ", isTimeOut=", Boolean.valueOf(asdt.a(this.a)), ", isFirstShow =", Boolean.valueOf(asdt.b(this.a)) });
      if (asdt.b(this.a)) {
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
      } while (asdt.a(this.a));
      i = paramawki.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramawki = (String[])paramawki.jdField_a_of_type_JavaLangObject;
        if ((paramawki != null) && (paramawki.length == 2))
        {
          QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramawki[0] + " ," + paramawki[1]);
          asdt.a(this.a, asdt.a(this.a), paramawki[0], paramawki[1]);
          return;
        }
        QLog.e("ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramawki.b;
    boolean bool = ForwardUtils.a(asdt.a(this.a));
    paramawki = (String[])paramawki.jdField_a_of_type_JavaLangObject;
    QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramawki != null) && (paramawki.length == 2))
    {
      QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramawki[0] + " ," + paramawki[1]);
      asdt.a(this.a, asdt.a(this.a), paramawki[0], paramawki[1]);
      return;
    }
    asdt.a(this.a, asdt.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdu
 * JD-Core Version:    0.7.0.1
 */