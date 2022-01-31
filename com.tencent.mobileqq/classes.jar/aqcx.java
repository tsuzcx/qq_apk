import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aqcx
  implements auoo
{
  aqcx(aqcw paramaqcw) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop)
  {
    if ((paramauop != null) && (QLog.isColorLevel())) {
      QLog.d(aqcw.a(), 2, "requestNormalShare updateMsg info =" + paramauop);
    }
  }
  
  public void b(auop paramauop)
  {
    String str = aqcw.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (aqcw.a(this.a))
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
      aqgh.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramauop));
      QLog.d(aqcw.a(), 1, new Object[] { "requestNormalShare onSend result =", paramauop, ", isTimeOut=", Boolean.valueOf(aqcw.a(this.a)) });
      if (!aqcw.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramauop))
    {
      paramauop = (String[])paramauop.jdField_a_of_type_JavaLangObject;
      QLog.i(aqcw.a(), 1, "requestNormalShare onSend urls=" + paramauop[0] + " ," + paramauop[1]);
      aqcw.a(this.a, paramauop[0], paramauop[1]);
      return;
    }
    int i = paramauop.b;
    boolean bool = ForwardUtils.a(aqcw.a(this.a));
    localObject = (String[])paramauop.jdField_a_of_type_JavaLangObject;
    QLog.e(aqcw.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramauop.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      aqcw.a(this.a, localObject[0], localObject[1]);
      return;
    }
    aqcw.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcx
 * JD-Core Version:    0.7.0.1
 */