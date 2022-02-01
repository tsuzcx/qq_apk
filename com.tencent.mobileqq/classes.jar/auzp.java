import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class auzp
  implements azrg
{
  auzp(auzo paramauzo) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh)
  {
    if ((paramazrh != null) && (QLog.isColorLevel())) {
      QLog.d(auzo.a(), 2, "requestNormalShare updateMsg info =" + paramazrh);
    }
  }
  
  public void b(azrh paramazrh)
  {
    String str = auzo.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (auzo.a(this.a))
    {
      localObject = "1";
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label125;
      }
    }
    label125:
    for (Object localObject = "";; localObject = str)
    {
      avcw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramazrh));
      QLog.d(auzo.a(), 1, new Object[] { "requestNormalShare onSend result =", paramazrh, ", isTimeOut=", Boolean.valueOf(auzo.a(this.a)) });
      if (!auzo.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramazrh))
    {
      paramazrh = (String[])paramazrh.jdField_a_of_type_JavaLangObject;
      QLog.i(auzo.a(), 1, "requestNormalShare onSend urls=" + paramazrh[0] + " ," + paramazrh[1]);
      auzo.a(this.a, paramazrh[0], paramazrh[1]);
      return;
    }
    int i = paramazrh.b;
    boolean bool = ForwardUtils.a(auzo.a(this.a));
    localObject = (String[])paramazrh.jdField_a_of_type_JavaLangObject;
    QLog.e(auzo.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramazrh.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      auzo.a(this.a, localObject[0], localObject[1]);
      return;
    }
    auzo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzp
 * JD-Core Version:    0.7.0.1
 */