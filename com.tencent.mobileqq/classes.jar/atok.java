import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class atok
  extends nmf
{
  atok(atoi paramatoi, long paramLong, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      bool = true;
      atqa.a("KEY_STAGE_2_NORMAL_B77", bool);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 10000L) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label123;
      }
      atoi.a(this.jdField_a_of_type_Atoi, new Object[] { Integer.valueOf(0), "", amtj.a(2131703918), "" }, -6);
      return;
      bool = false;
      break;
    }
    label123:
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      if ((l == -1L) || (l != atoi.a(this.jdField_a_of_type_Atoi)))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "handleGetMessageState currentRequestTime =" + atoi.a(this.jdField_a_of_type_Atoi) + ", sendStamp = " + l);
        return;
      }
    }
    paramBundle = ForwardUtils.reqTypeToReportData(this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"));
    Object localObject = ForwardUtils.toType(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    bcef.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, paramBundle, (String)localObject, str);
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      atoi.a(this.jdField_a_of_type_Atoi, this.jdField_a_of_type_AndroidOsBundle);
    }
    paramBundle = this.jdField_a_of_type_Atoi;
    localObject = ForwardUtils.parseOIDBb77RspBody(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      paramInt = -7;
    }
    atoi.a(paramBundle, (Object[])localObject, paramInt);
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atok
 * JD-Core Version:    0.7.0.1
 */