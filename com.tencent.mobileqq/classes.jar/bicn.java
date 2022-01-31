import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bicn
  extends bice
{
  private WeakReference<bici> a;
  
  bicn(bici parambici)
  {
    this.a = new WeakReference(parambici);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    bici localbici = (bici)this.a.get();
    if (localbici == null) {
      bdot.b("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          bdot.b("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
      } while (paramString == null);
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = bici.a(localbici).obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        bici.a(localbici).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = bici.a(localbici).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        bici.a(localbici).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = bici.a(localbici).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        bici.a(localbici).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = bici.a(localbici).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    bici.a(localbici).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bicn
 * JD-Core Version:    0.7.0.1
 */