import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class aqdb
  extends mxj
{
  aqdb(aqcy paramaqcy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aqgj.a("KEY_STAGE_2_IMAGE_DC2", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(aqcy.a(), 2, new Object[] { "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(aqcy.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l != -1L) && (l == aqcy.a(this.a))) {
        break;
      }
      aqcy.a(this.a);
      return;
    }
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(aqcy.a(), 1, new Object[] { "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      aqcy.a(this.a);
      return;
    }
    aqcy.a(this.a, paramArrayOfByte);
    ForwardUtils.a(aqcy.a(this.a), paramArrayOfByte, aqcy.a(this.a), aqcy.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(aqcy.a(), 1, "notifyImageSendMessage onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdb
 * JD-Core Version:    0.7.0.1
 */