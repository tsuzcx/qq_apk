import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class avoc
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((avob.a != null) && (avob.a.size() > 0))
    {
      Iterator localIterator = avob.a.iterator();
      while (localIterator.hasNext())
      {
        avob localavob = (avob)((WeakReference)localIterator.next()).get();
        if (localavob != null) {
          localavob.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoc
 * JD-Core Version:    0.7.0.1
 */