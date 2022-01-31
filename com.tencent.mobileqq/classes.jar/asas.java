import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class asas
  extends nac
{
  asas(asap paramasap) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aseh.a("KEY_STAGE_2_IMAGE_DC2", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(asap.a(), 2, new Object[] { "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(asap.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l != -1L) && (l == asap.a(this.a))) {
        break;
      }
      asap.a(this.a);
      return;
    }
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(asap.a(), 1, new Object[] { "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      asap.a(this.a);
      return;
    }
    asap.a(this.a, paramArrayOfByte);
    ForwardUtils.a(asap.a(this.a), paramArrayOfByte, asap.a(this.a), asap.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(asap.a(), 1, "notifyImageSendMessage onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asas
 * JD-Core Version:    0.7.0.1
 */