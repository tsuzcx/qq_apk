import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class auto
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((autn.a != null) && (autn.a.size() > 0))
    {
      Iterator localIterator = autn.a.iterator();
      while (localIterator.hasNext())
      {
        autn localautn = (autn)((WeakReference)localIterator.next()).get();
        if (localautn != null) {
          localautn.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auto
 * JD-Core Version:    0.7.0.1
 */