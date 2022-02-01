import android.os.Bundle;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@ProxyService(proxy=SpecialProxy.class)
public class bkrq
  implements SpecialProxy
{
  private void a(Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    if (paramBundle == null) {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
    }
    do
    {
      do
      {
        return;
        paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        paramBundle = bkpw.a((MiniAppInfo)paramBundle.getParcelable("mini_appinfo"));
        if (paramBundle != null) {
          break;
        }
      } while (paramEventCallback == null);
      paramEventCallback.onResult(false, null);
      return;
      MiniAppUtils.notityPullDownEntryInMainProcess(paramBundle);
    } while (paramEventCallback == null);
    paramEventCallback.onResult(true, null);
  }
  
  public boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    QLog.i("SpecialProxyImpl", 1, "receive event from minisdk, event:" + paramInt);
    if (1 == paramInt) {
      try
      {
        a(paramBundle, paramEventCallback);
        return true;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("SpecialProxyImpl", 1, "exception when receive event from minisdk", paramBundle);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrq
 * JD-Core Version:    0.7.0.1
 */