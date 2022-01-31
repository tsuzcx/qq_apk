import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class ayqw
  extends SSOAccountObserver
{
  ayqw(ayqv paramayqv) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onFailed|account=" + paramString + ",ret=" + paramInt2);
    if (ayqr.b(this.a.b) == 11) {
      aqgh.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|onGetTicketNoPasswd|account=" + paramString + ",type=" + paramInt);
    }
    if (ayqr.b(this.a.b) == 11) {
      aqgh.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      ayqr.d(this.a.b, new String(paramArrayOfByte));
      ayqv.a(this.a).set(true);
      bdke.a(paramString, l);
      this.a.b();
      return;
    }
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onUserCancel|action=" + paramInt);
    if (ayqr.b(this.a.b) == 11) {
      aqgh.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.b.b(9401, "onUserCancel");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqw
 * JD-Core Version:    0.7.0.1
 */