import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class asaq
  implements awkh
{
  asaq(asap paramasap) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki)
  {
    if ((paramawki != null) && (QLog.isColorLevel())) {
      QLog.d(asap.a(), 2, "requestNormalShare updateMsg info =" + paramawki);
    }
  }
  
  public void b(awki paramawki)
  {
    String str = asap.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (asap.a(this.a))
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
      aseh.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramawki));
      QLog.d(asap.a(), 1, new Object[] { "requestNormalShare onSend result =", paramawki, ", isTimeOut=", Boolean.valueOf(asap.a(this.a)) });
      if (!asap.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramawki))
    {
      paramawki = (String[])paramawki.jdField_a_of_type_JavaLangObject;
      QLog.i(asap.a(), 1, "requestNormalShare onSend urls=" + paramawki[0] + " ," + paramawki[1]);
      asap.a(this.a, paramawki[0], paramawki[1]);
      return;
    }
    int i = paramawki.b;
    boolean bool = ForwardUtils.a(asap.a(this.a));
    localObject = (String[])paramawki.jdField_a_of_type_JavaLangObject;
    QLog.e(asap.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramawki.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      asap.a(this.a, localObject[0], localObject[1]);
      return;
    }
    asap.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaq
 * JD-Core Version:    0.7.0.1
 */