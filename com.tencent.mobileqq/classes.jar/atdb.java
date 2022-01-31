import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class atdb
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((atda.a != null) && (atda.a.size() > 0))
    {
      Iterator localIterator = atda.a.iterator();
      while (localIterator.hasNext())
      {
        atda localatda = (atda)((WeakReference)localIterator.next()).get();
        if (localatda != null) {
          localatda.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdb
 * JD-Core Version:    0.7.0.1
 */