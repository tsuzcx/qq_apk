import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bgsu
  extends bgsl
{
  private WeakReference<bgsp> a;
  
  bgsu(bgsp parambgsp)
  {
    this.a = new WeakReference(parambgsp);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    bgsp localbgsp = (bgsp)this.a.get();
    if (localbgsp == null) {
      bckd.b("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          bckd.b("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
      } while (paramString == null);
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = bgsp.a(localbgsp).obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        bgsp.a(localbgsp).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = bgsp.a(localbgsp).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        bgsp.a(localbgsp).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = bgsp.a(localbgsp).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        bgsp.a(localbgsp).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = bgsp.a(localbgsp).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    bgsp.a(localbgsp).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsu
 * JD-Core Version:    0.7.0.1
 */