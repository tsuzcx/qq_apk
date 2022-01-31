import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class baot
  extends SSOAccountObserver
{
  baot(baos parambaos) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onFailed|account=" + paramString + ",ret=" + paramInt2);
    if (baoo.b(this.a.b) == 11) {
      arzy.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|onGetTicketNoPasswd|account=" + paramString + ",type=" + paramInt);
    }
    if (baoo.b(this.a.b) == 11) {
      arzy.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      baoo.d(this.a.b, new String(paramArrayOfByte));
      baos.a(this.a).set(true);
      bfjq.a(paramString, l);
      this.a.b();
      return;
    }
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onUserCancel|action=" + paramInt);
    if (baoo.b(this.a.b) == 11) {
      arzy.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.b.b(9401, "onUserCancel");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baot
 * JD-Core Version:    0.7.0.1
 */