import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aqcz
  implements auoq
{
  aqcz(aqcy paramaqcy) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor)
  {
    if ((paramauor != null) && (QLog.isColorLevel())) {
      QLog.d(aqcy.a(), 2, "requestNormalShare updateMsg info =" + paramauor);
    }
  }
  
  public void b(auor paramauor)
  {
    String str = aqcy.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (aqcy.a(this.a))
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
      aqgj.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramauor));
      QLog.d(aqcy.a(), 1, new Object[] { "requestNormalShare onSend result =", paramauor, ", isTimeOut=", Boolean.valueOf(aqcy.a(this.a)) });
      if (!aqcy.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramauor))
    {
      paramauor = (String[])paramauor.jdField_a_of_type_JavaLangObject;
      QLog.i(aqcy.a(), 1, "requestNormalShare onSend urls=" + paramauor[0] + " ," + paramauor[1]);
      aqcy.a(this.a, paramauor[0], paramauor[1]);
      return;
    }
    int i = paramauor.b;
    boolean bool = ForwardUtils.a(aqcy.a(this.a));
    localObject = (String[])paramauor.jdField_a_of_type_JavaLangObject;
    QLog.e(aqcy.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramauor.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      aqcy.a(this.a, localObject[0], localObject[1]);
      return;
    }
    aqcy.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcz
 * JD-Core Version:    0.7.0.1
 */