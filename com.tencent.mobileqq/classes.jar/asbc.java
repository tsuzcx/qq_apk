import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

final class asbc
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = ((Long)paramMessage.obj).longValue();
      if (asbb.a().containsKey(Long.valueOf(l)))
      {
        WeakReference localWeakReference = (WeakReference)asbb.a().get(Long.valueOf(l));
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((asbd)localWeakReference.get()).a(paramMessage.arg1);
          asbb.a().remove(Long.valueOf(l));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbc
 * JD-Core Version:    0.7.0.1
 */