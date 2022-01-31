import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class athk
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((athj.a != null) && (athj.a.size() > 0))
    {
      Iterator localIterator = athj.a.iterator();
      while (localIterator.hasNext())
      {
        athj localathj = (athj)((WeakReference)localIterator.next()).get();
        if (localathj != null) {
          localathj.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athk
 * JD-Core Version:    0.7.0.1
 */