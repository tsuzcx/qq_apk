import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class auzs
  extends nkq
{
  auzs(auzo paramauzo) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d(auzo.a(), 1, new Object[] { "notifyNormalSendMessage onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(auzo.a(this.a)) });
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      avcw.a("KEY_STAGE_2_NORMAL_DC2", bool);
      if (!auzo.a(this.a)) {
        break;
      }
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(auzo.a(), 2, new Object[] { "notifyNormalSendMessage currentRequestTime =", Long.valueOf(auzo.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l == -1L) || (l != auzo.a(this.a)))
      {
        auzo.a(this.a);
        return;
      }
    }
    bdll.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, "", "", "");
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(auzo.a(), 1, new Object[] { "notifyNormalSendMessage sendOIDBRequest onResult errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      auzo.a(this.a);
      return;
    }
    auzo.a(this.a, paramArrayOfByte);
    ForwardUtils.a(auzo.a(this.a), paramArrayOfByte, auzo.a(this.a), auzo.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(auzo.a(), 1, new Object[] { "notifyNormalSendMessage onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzs
 * JD-Core Version:    0.7.0.1
 */