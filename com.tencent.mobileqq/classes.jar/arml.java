import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class arml
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((armk.a != null) && (armk.a.size() > 0))
    {
      Iterator localIterator = armk.a.iterator();
      while (localIterator.hasNext())
      {
        armk localarmk = (armk)((WeakReference)localIterator.next()).get();
        if (localarmk != null) {
          localarmk.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arml
 * JD-Core Version:    0.7.0.1
 */