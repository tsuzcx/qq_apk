import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class bemi
  extends Handler
{
  public bemi()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (String[])paramMessage.obj;
    Object localObject = paramMessage[0];
    CharSequence localCharSequence = paramMessage[1];
    WeakReference localWeakReference = (WeakReference)bema.a.remove(localObject);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      if (!(((TextView)localWeakReference.get()).getTag() instanceof String[])) {
        break label142;
      }
      paramMessage = (String[])((TextView)localWeakReference.get()).getTag();
    }
    for (;;)
    {
      if ((paramMessage != null) && (paramMessage.length == 2) && (paramMessage[0].equals(localObject))) {}
      try
      {
        ((TextView)localWeakReference.get()).setText(String.format(paramMessage[1], new Object[] { localCharSequence }));
        ((TextView)localWeakReference.get()).setText(localCharSequence);
        return;
        label142:
        paramMessage = null;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          ((TextView)localWeakReference.get()).setText(localCharSequence);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemi
 * JD-Core Version:    0.7.0.1
 */