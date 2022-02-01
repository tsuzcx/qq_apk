import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class atmt
  implements ayeo
{
  atmt(atms paramatms) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    String str = atms.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (atms.a(this.a))
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
      atqa.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.isShareProcessorSuccess(paramayep));
      QLog.d(atms.a(), 1, new Object[] { "requestNormalShare onSend result =", paramayep, ", isTimeOut=", Boolean.valueOf(atms.a(this.a)) });
      if (!atms.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.isShareProcessorSuccess(paramayep))
    {
      paramayep = (String[])paramayep.jdField_a_of_type_JavaLangObject;
      QLog.i(atms.a(), 1, "requestNormalShare onSend urls=" + paramayep[0] + " ," + paramayep[1]);
      atms.a(this.a, paramayep[0], paramayep[1]);
      return;
    }
    int i = paramayep.b;
    boolean bool = ForwardUtils.hasSDPermission(atms.a(this.a));
    localObject = (String[])paramayep.jdField_a_of_type_JavaLangObject;
    QLog.e(atms.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramayep.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      atms.a(this.a, localObject[0], localObject[1]);
      return;
    }
    atms.a(this.a);
  }
  
  public void updateMsg(ayep paramayep)
  {
    if ((paramayep != null) && (QLog.isColorLevel())) {
      QLog.d(atms.a(), 2, "requestNormalShare updateMsg info =" + paramayep);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmt
 * JD-Core Version:    0.7.0.1
 */