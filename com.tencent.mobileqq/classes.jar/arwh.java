import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class arwh
  implements awfy
{
  arwh(arwg paramarwg) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz)
  {
    if ((paramawfz != null) && (QLog.isColorLevel())) {
      QLog.d(arwg.a(), 2, "requestNormalShare updateMsg info =" + paramawfz);
    }
  }
  
  public void b(awfz paramawfz)
  {
    String str = arwg.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (arwg.a(this.a))
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
      arzy.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramawfz));
      QLog.d(arwg.a(), 1, new Object[] { "requestNormalShare onSend result =", paramawfz, ", isTimeOut=", Boolean.valueOf(arwg.a(this.a)) });
      if (!arwg.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramawfz))
    {
      paramawfz = (String[])paramawfz.jdField_a_of_type_JavaLangObject;
      QLog.i(arwg.a(), 1, "requestNormalShare onSend urls=" + paramawfz[0] + " ," + paramawfz[1]);
      arwg.a(this.a, paramawfz[0], paramawfz[1]);
      return;
    }
    int i = paramawfz.b;
    boolean bool = ForwardUtils.a(arwg.a(this.a));
    localObject = (String[])paramawfz.jdField_a_of_type_JavaLangObject;
    QLog.e(arwg.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramawfz.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      arwg.a(this.a, localObject[0], localObject[1]);
      return;
    }
    arwg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwh
 * JD-Core Version:    0.7.0.1
 */