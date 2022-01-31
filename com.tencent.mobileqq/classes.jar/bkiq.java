import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bkiq
  extends bkih
{
  private WeakReference<bkil> a;
  
  bkiq(bkil parambkil)
  {
    this.a = new WeakReference(parambkil);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    bkil localbkil = (bkil)this.a.get();
    if (localbkil == null) {
      bfrz.c("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          bfrz.c("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
      } while (paramString == null);
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = bkil.a(localbkil).obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        bkil.a(localbkil).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = bkil.a(localbkil).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        bkil.a(localbkil).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = bkil.a(localbkil).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        bkil.a(localbkil).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = bkil.a(localbkil).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    bkil.a(localbkil).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkiq
 * JD-Core Version:    0.7.0.1
 */