import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bibw
  extends bibn
{
  private WeakReference<bibr> a;
  
  bibw(bibr parambibr)
  {
    this.a = new WeakReference(parambibr);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    bibr localbibr = (bibr)this.a.get();
    if (localbibr == null) {
      bdoe.b("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          bdoe.b("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
      } while (paramString == null);
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = bibr.a(localbibr).obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        bibr.a(localbibr).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = bibr.a(localbibr).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        bibr.a(localbibr).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = bibr.a(localbibr).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        bibr.a(localbibr).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = bibr.a(localbibr).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    bibr.a(localbibr).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibw
 * JD-Core Version:    0.7.0.1
 */