import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bkej
  extends bkea
{
  private WeakReference<bkee> a;
  
  bkej(bkee parambkee)
  {
    this.a = new WeakReference(parambkee);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    bkee localbkee = (bkee)this.a.get();
    if (localbkee == null) {
      bfnq.c("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          bfnq.c("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
      } while (paramString == null);
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = bkee.a(localbkee).obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        bkee.a(localbkee).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = bkee.a(localbkee).obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        bkee.a(localbkee).sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = bkee.a(localbkee).obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        bkee.a(localbkee).sendMessage(paramString);
        return;
      }
    } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
    paramString = bkee.a(localbkee).obtainMessage();
    paramString.what = 6;
    paramString.setData(paramBundle);
    bkee.a(localbkee).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkej
 * JD-Core Version:    0.7.0.1
 */