import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aqfw
  implements auoq
{
  aqfw(aqfv paramaqfv) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor)
  {
    if (paramauor != null) {
      QLog.d("ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramauor);
    }
  }
  
  public void b(auor paramauor)
  {
    String str2 = aqfv.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (aqfv.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!aqfv.b(this.a)) {
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
      aqgj.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramauor));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramauor, ", isTimeOut=", Boolean.valueOf(aqfv.a(this.a)), ", isFirstShow =", Boolean.valueOf(aqfv.b(this.a)) });
      if (aqfv.b(this.a)) {
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
      } while (aqfv.a(this.a));
      i = paramauor.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramauor = (String[])paramauor.jdField_a_of_type_JavaLangObject;
        if ((paramauor != null) && (paramauor.length == 2))
        {
          QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramauor[0] + " ," + paramauor[1]);
          aqfv.a(this.a, aqfv.a(this.a), paramauor[0], paramauor[1]);
          return;
        }
        QLog.e("ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramauor.b;
    boolean bool = ForwardUtils.a(aqfv.a(this.a));
    paramauor = (String[])paramauor.jdField_a_of_type_JavaLangObject;
    QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramauor != null) && (paramauor.length == 2))
    {
      QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramauor[0] + " ," + paramauor[1]);
      aqfv.a(this.a, aqfv.a(this.a), paramauor[0], paramauor[1]);
      return;
    }
    aqfv.a(this.a, aqfv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfw
 * JD-Core Version:    0.7.0.1
 */