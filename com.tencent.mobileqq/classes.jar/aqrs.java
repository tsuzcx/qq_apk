import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class aqrs
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aqrr.a != null) && (aqrr.a.size() > 0))
    {
      Iterator localIterator = aqrr.a.iterator();
      while (localIterator.hasNext())
      {
        aqrr localaqrr = (aqrr)((WeakReference)localIterator.next()).get();
        if (localaqrr != null) {
          localaqrr.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrs
 * JD-Core Version:    0.7.0.1
 */