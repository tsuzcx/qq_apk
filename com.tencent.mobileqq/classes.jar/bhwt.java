import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class bhwt
  extends Handler
{
  public bhwt(PathTraceManager paramPathTraceManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        paramMessage = (JSONObject)paramMessage.obj;
        String str = paramMessage.getString("callback");
        if (this.a.a != null)
        {
          bhwj localbhwj = (bhwj)this.a.a.get();
          if (localbhwj != null)
          {
            localbhwj.callJs(str, new String[] { paramMessage.toString() });
            return;
          }
        }
      }
      catch (Exception paramMessage) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwt
 * JD-Core Version:    0.7.0.1
 */