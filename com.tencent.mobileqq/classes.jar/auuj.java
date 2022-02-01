import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class auuj
  implements azla
{
  auuj(auui paramauui) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    String str2 = auui.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (auui.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!auui.b(this.a)) {
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
      auuv.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.isShareProcessorSuccess(paramazlb));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramazlb, ", isTimeOut=", Boolean.valueOf(auui.a(this.a)), ", isFirstShow =", Boolean.valueOf(auui.b(this.a)) });
      if (auui.b(this.a)) {
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
      } while (auui.a(this.a));
      i = paramazlb.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramazlb = (String[])paramazlb.jdField_a_of_type_JavaLangObject;
        if ((paramazlb != null) && (paramazlb.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramazlb[0] + " ," + paramazlb[1]);
          auui.a(this.a, auui.a(this.a), paramazlb[0], paramazlb[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramazlb.b;
    boolean bool = ForwardUtils.hasSDPermission(auui.a(this.a));
    paramazlb = (String[])paramazlb.jdField_a_of_type_JavaLangObject;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramazlb != null) && (paramazlb.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramazlb[0] + " ," + paramazlb[1]);
      auui.a(this.a, auui.a(this.a), paramazlb[0], paramazlb[1]);
      return;
    }
    auui.a(this.a, auui.a);
  }
  
  public void updateMsg(azlb paramazlb)
  {
    if (paramazlb != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramazlb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuj
 * JD-Core Version:    0.7.0.1
 */