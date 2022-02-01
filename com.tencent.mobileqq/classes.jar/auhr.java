import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class auhr
  implements ayyt
{
  auhr(auhq paramauhq) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu)
  {
    if ((paramayyu != null) && (QLog.isColorLevel())) {
      QLog.d(auhq.a(), 2, "requestNormalShare updateMsg info =" + paramayyu);
    }
  }
  
  public void b(ayyu paramayyu)
  {
    String str = auhq.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (auhq.a(this.a))
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
      aukw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramayyu));
      QLog.d(auhq.a(), 1, new Object[] { "requestNormalShare onSend result =", paramayyu, ", isTimeOut=", Boolean.valueOf(auhq.a(this.a)) });
      if (!auhq.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramayyu))
    {
      paramayyu = (String[])paramayyu.jdField_a_of_type_JavaLangObject;
      QLog.i(auhq.a(), 1, "requestNormalShare onSend urls=" + paramayyu[0] + " ," + paramayyu[1]);
      auhq.a(this.a, paramayyu[0], paramayyu[1]);
      return;
    }
    int i = paramayyu.b;
    boolean bool = ForwardUtils.a(auhq.a(this.a));
    localObject = (String[])paramayyu.jdField_a_of_type_JavaLangObject;
    QLog.e(auhq.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramayyu.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      auhq.a(this.a, localObject[0], localObject[1]);
      return;
    }
    auhq.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhr
 * JD-Core Version:    0.7.0.1
 */