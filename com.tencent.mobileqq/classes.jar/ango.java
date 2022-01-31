import android.os.Bundle;
import android.os.Message;
import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.IWadlServiceCallBack.Stub;
import cooperation.wadl.ipc.WadlProxyServiceManager;

public class ango
  extends IWadlServiceCallBack.Stub
{
  public ango(WadlProxyServiceManager paramWadlProxyServiceManager) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      WLog.b("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (!paramString.equals("WADL.REVERSE_HEART_CMD")) {
        break label88;
      }
      paramString = WadlProxyServiceManager.a(this.a).obtainMessage();
      paramString.what = 4;
      paramString.setData(paramBundle);
      WadlProxyServiceManager.a(this.a).sendMessage(paramString);
    }
    label88:
    do
    {
      return;
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = WadlProxyServiceManager.a(this.a).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        WadlProxyServiceManager.a(this.a).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = WadlProxyServiceManager.a(this.a).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        WadlProxyServiceManager.a(this.a).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = WadlProxyServiceManager.a(this.a).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    WadlProxyServiceManager.a(this.a).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ango
 * JD-Core Version:    0.7.0.1
 */