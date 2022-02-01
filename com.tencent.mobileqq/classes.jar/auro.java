import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class auro
  implements azla
{
  auro(aurn paramaurn) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    String str = aurn.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (aurn.a(this.a))
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
      auuv.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.isShareProcessorSuccess(paramazlb));
      QLog.d(aurn.a(), 1, new Object[] { "requestNormalShare onSend result =", paramazlb, ", isTimeOut=", Boolean.valueOf(aurn.a(this.a)) });
      if (!aurn.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.isShareProcessorSuccess(paramazlb))
    {
      paramazlb = (String[])paramazlb.jdField_a_of_type_JavaLangObject;
      QLog.i(aurn.a(), 1, "requestNormalShare onSend urls=" + paramazlb[0] + " ," + paramazlb[1]);
      aurn.a(this.a, paramazlb[0], paramazlb[1]);
      return;
    }
    int i = paramazlb.b;
    boolean bool = ForwardUtils.hasSDPermission(aurn.a(this.a));
    localObject = (String[])paramazlb.jdField_a_of_type_JavaLangObject;
    QLog.e(aurn.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramazlb.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      aurn.a(this.a, localObject[0], localObject[1]);
      return;
    }
    aurn.a(this.a);
  }
  
  public void updateMsg(azlb paramazlb)
  {
    if ((paramazlb != null) && (QLog.isColorLevel())) {
      QLog.d(aurn.a(), 2, "requestNormalShare updateMsg info =" + paramazlb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auro
 * JD-Core Version:    0.7.0.1
 */