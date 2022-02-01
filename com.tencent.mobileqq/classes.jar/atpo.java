import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class atpo
  implements ayeo
{
  atpo(atpn paramatpn) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    String str2 = atpn.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (atpn.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!atpn.b(this.a)) {
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
      atqa.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.isShareProcessorSuccess(paramayep));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramayep, ", isTimeOut=", Boolean.valueOf(atpn.a(this.a)), ", isFirstShow =", Boolean.valueOf(atpn.b(this.a)) });
      if (atpn.b(this.a)) {
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
      } while (atpn.a(this.a));
      i = paramayep.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramayep = (String[])paramayep.jdField_a_of_type_JavaLangObject;
        if ((paramayep != null) && (paramayep.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramayep[0] + " ," + paramayep[1]);
          atpn.a(this.a, atpn.a(this.a), paramayep[0], paramayep[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramayep.b;
    boolean bool = ForwardUtils.hasSDPermission(atpn.a(this.a));
    paramayep = (String[])paramayep.jdField_a_of_type_JavaLangObject;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramayep != null) && (paramayep.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramayep[0] + " ," + paramayep[1]);
      atpn.a(this.a, atpn.a(this.a), paramayep[0], paramayep[1]);
      return;
    }
    atpn.a(this.a, atpn.a);
  }
  
  public void updateMsg(ayep paramayep)
  {
    if (paramayep != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramayep);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpo
 * JD-Core Version:    0.7.0.1
 */