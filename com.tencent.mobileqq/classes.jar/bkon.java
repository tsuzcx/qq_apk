import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dov.com.qq.im.ae.view.TabLayout;
import mqq.util.WeakReference;

final class bkon
  extends BroadcastReceiver
{
  private TabLayout a;
  
  public void a(TabLayout paramTabLayout)
  {
    this.a = ((TabLayout)new WeakReference(paramTabLayout).get());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("is_show", true);
    if (this.a != null)
    {
      paramContext = this.a;
      if (!bool) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      paramContext.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkon
 * JD-Core Version:    0.7.0.1
 */