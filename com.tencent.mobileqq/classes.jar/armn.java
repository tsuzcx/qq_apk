import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class armn
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((armm.a != null) && (armm.a.size() > 0))
    {
      Iterator localIterator = armm.a.iterator();
      while (localIterator.hasNext())
      {
        armm localarmm = (armm)((WeakReference)localIterator.next()).get();
        if (localarmm != null) {
          localarmm.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armn
 * JD-Core Version:    0.7.0.1
 */