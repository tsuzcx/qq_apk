import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class awgn
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((awgm.a != null) && (awgm.a.size() > 0))
    {
      Iterator localIterator = awgm.a.iterator();
      while (localIterator.hasNext())
      {
        awgm localawgm = (awgm)((WeakReference)localIterator.next()).get();
        if (localawgm != null) {
          localawgm.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgn
 * JD-Core Version:    0.7.0.1
 */