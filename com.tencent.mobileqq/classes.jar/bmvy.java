import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import dov.com.qq.im.ae.view.TabLayout;
import mqq.util.WeakReference;

final class bmvy
  extends BroadcastReceiver
{
  private TabLayout a;
  
  public void a(TabLayout paramTabLayout)
  {
    this.a = ((TabLayout)new WeakReference(paramTabLayout).get());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (!"ae_editor_bottom_tab_show_hide".equals(paramContext)) {
            break;
          }
          bool = paramIntent.getBooleanExtra("is_show", true);
        } while (this.a == null);
        paramContext = this.a;
        if (bool) {}
        for (;;)
        {
          paramContext.setVisibility(i);
          return;
          i = 8;
        }
      } while (!"ae_editor_bottom_tab_change_style".equals(paramContext));
      bool = paramIntent.getBooleanExtra("is_full_screen_capture", false);
    } while (this.a == null);
    this.a.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvy
 * JD-Core Version:    0.7.0.1
 */