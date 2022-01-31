import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

class aryg
  extends nac
{
  aryg(arye paramarye, long paramLong, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      bool = true;
      arzy.a("KEY_STAGE_2_NORMAL_B77", bool);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 10000L) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label122;
      }
      arye.a(this.jdField_a_of_type_Arye, new Object[] { Integer.valueOf(0), "", alpo.a(2131705173), "" }, -1);
      return;
      bool = false;
      break;
    }
    label122:
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      if ((l == -1L) || (l != arye.a(this.jdField_a_of_type_Arye)))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "handleGetMessageState currentRequestTime =" + arye.a(this.jdField_a_of_type_Arye) + ", sendStamp = " + l);
        return;
      }
    }
    Object localObject = ForwardUtils.c(arye.a(this.jdField_a_of_type_Arye).getInt("req_type"));
    String str = ForwardUtils.a(arye.a(this.jdField_a_of_type_Arye).getInt("uintype"));
    if ((arye.a(this.jdField_a_of_type_Arye) instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)arye.a(this.jdField_a_of_type_Arye)).mContentTitle;; paramBundle = "")
    {
      azmj.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, (String)localObject, str, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        arye.a(this.jdField_a_of_type_Arye, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      }
      paramBundle = this.jdField_a_of_type_Arye;
      localObject = ForwardUtils.a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        paramInt = -1;
      }
      arye.a(paramBundle, (Object[])localObject, paramInt);
      return;
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryg
 * JD-Core Version:    0.7.0.1
 */