import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class arom
  extends BroadcastReceiver
{
  public arom(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((UiApiPlugin.a != null) && (UiApiPlugin.a.size() > 0))
    {
      Iterator localIterator = UiApiPlugin.a.iterator();
      while (localIterator.hasNext())
      {
        UiApiPlugin localUiApiPlugin = (UiApiPlugin)((WeakReference)localIterator.next()).get();
        if (localUiApiPlugin != null) {
          localUiApiPlugin.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arom
 * JD-Core Version:    0.7.0.1
 */