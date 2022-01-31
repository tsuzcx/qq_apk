import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aqfu
  implements auoo
{
  aqfu(aqft paramaqft) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop)
  {
    if (paramauop != null) {
      QLog.d("ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramauop);
    }
  }
  
  public void b(auop paramauop)
  {
    String str2 = aqft.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (aqft.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!aqft.b(this.a)) {
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
      aqgh.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramauop));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramauop, ", isTimeOut=", Boolean.valueOf(aqft.a(this.a)), ", isFirstShow =", Boolean.valueOf(aqft.b(this.a)) });
      if (aqft.b(this.a)) {
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
      } while (aqft.a(this.a));
      i = paramauop.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramauop = (String[])paramauop.jdField_a_of_type_JavaLangObject;
        if ((paramauop != null) && (paramauop.length == 2))
        {
          QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramauop[0] + " ," + paramauop[1]);
          aqft.a(this.a, aqft.a(this.a), paramauop[0], paramauop[1]);
          return;
        }
        QLog.e("ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramauop.b;
    boolean bool = ForwardUtils.a(aqft.a(this.a));
    paramauop = (String[])paramauop.jdField_a_of_type_JavaLangObject;
    QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramauop != null) && (paramauop.length == 2))
    {
      QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramauop[0] + " ," + paramauop[1]);
      aqft.a(this.a, aqft.a(this.a), paramauop[0], paramauop[1]);
      return;
    }
    aqft.a(this.a, aqft.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfu
 * JD-Core Version:    0.7.0.1
 */