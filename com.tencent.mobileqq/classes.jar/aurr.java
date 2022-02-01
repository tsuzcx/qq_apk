import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class aurr
  extends ntf
{
  aurr(aurn paramaurn) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d(aurn.a(), 1, new Object[] { "notifyNormalSendMessage onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(aurn.a(this.a)) });
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      auuv.a("KEY_STAGE_2_NORMAL_DC2", bool);
      if (!aurn.a(this.a)) {
        break;
      }
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(aurn.a(), 2, new Object[] { "notifyNormalSendMessage currentRequestTime =", Long.valueOf(aurn.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l == -1L) || (l != aurn.a(this.a)))
      {
        aurn.a(this.a);
        return;
      }
    }
    bdla.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, "", "", "");
    paramArrayOfByte = ForwardUtils.parseOIDBdc2RspBody(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(aurn.a(), 1, new Object[] { "notifyNormalSendMessage sendOIDBRequest onResult errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      aurn.a(this.a);
      return;
    }
    aurn.a(this.a, paramArrayOfByte);
    ForwardUtils.sendCommentMsg(aurn.a(this.a), paramArrayOfByte, aurn.a(this.a), aurn.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(aurn.a(), 1, new Object[] { "notifyNormalSendMessage onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurr
 * JD-Core Version:    0.7.0.1
 */