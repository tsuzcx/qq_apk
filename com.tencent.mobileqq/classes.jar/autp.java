import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class autp
  extends SSOAccountObserver
{
  WeakReference<ForwardSdkBaseOption> a;
  
  public autp(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    this.a = new WeakReference(paramForwardSdkBaseOption);
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("ForwardSdkBaseOption", 1, new Object[] { "-->onFailed--account = ", paramString, ", ret = ", Integer.valueOf(paramInt2) });
    paramString = (ForwardSdkBaseOption)this.a.get();
    if ((paramString != null) && (paramBundle != null)) {
      ForwardSdkBaseOption.a(paramString, "KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    if ((paramString != null) && (!paramString.m) && (ForwardSdkBaseOption.a(paramString) != null)) {
      ForwardSdkBaseOption.a(paramString).sendEmptyMessage(0);
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("ForwardSdkBaseOption", 1, new Object[] { "-->onGetTicketNoPasswd--recv g_t_n_p, account = ", paramString });
    if (paramInt == 4096) {}
    for (paramString = new String(paramArrayOfByte);; paramString = null)
    {
      paramArrayOfByte = (ForwardSdkBaseOption)this.a.get();
      if (paramArrayOfByte != null)
      {
        ForwardSdkBaseOption.a(paramArrayOfByte, "KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
        paramArrayOfByte.k = paramString;
        paramArrayOfByte.m = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autp
 * JD-Core Version:    0.7.0.1
 */