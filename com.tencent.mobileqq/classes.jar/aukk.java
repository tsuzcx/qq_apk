import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aukk
  implements ayyt
{
  aukk(aukj paramaukj) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu)
  {
    if (paramayyu != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramayyu);
    }
  }
  
  public void b(ayyu paramayyu)
  {
    String str2 = aukj.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (aukj.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!aukj.b(this.a)) {
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
      aukw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramayyu));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramayyu, ", isTimeOut=", Boolean.valueOf(aukj.a(this.a)), ", isFirstShow =", Boolean.valueOf(aukj.b(this.a)) });
      if (aukj.b(this.a)) {
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
      } while (aukj.a(this.a));
      i = paramayyu.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramayyu = (String[])paramayyu.jdField_a_of_type_JavaLangObject;
        if ((paramayyu != null) && (paramayyu.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramayyu[0] + " ," + paramayyu[1]);
          aukj.a(this.a, aukj.a(this.a), paramayyu[0], paramayyu[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramayyu.b;
    boolean bool = ForwardUtils.a(aukj.a(this.a));
    paramayyu = (String[])paramayyu.jdField_a_of_type_JavaLangObject;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramayyu != null) && (paramayyu.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramayyu[0] + " ," + paramayyu[1]);
      aukj.a(this.a, aukj.a(this.a), paramayyu[0], paramayyu[1]);
      return;
    }
    aukj.a(this.a, aukj.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukk
 * JD-Core Version:    0.7.0.1
 */