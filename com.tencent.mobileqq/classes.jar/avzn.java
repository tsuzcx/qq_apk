import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class avzn
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((avzm.a != null) && (avzm.a.size() > 0))
    {
      Iterator localIterator = avzm.a.iterator();
      while (localIterator.hasNext())
      {
        avzm localavzm = (avzm)((WeakReference)localIterator.next()).get();
        if (localavzm != null) {
          localavzm.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzn
 * JD-Core Version:    0.7.0.1
 */