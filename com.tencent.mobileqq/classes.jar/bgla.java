import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMessageShortcutBarPanel.3.1;
import mqq.os.MqqHandler;

public class bgla
  implements PopupWindow.OnDismissListener
{
  bgla(bgkx parambgkx) {}
  
  public void onDismiss()
  {
    if ((bgkx.a(this.a) != null) && (bgkx.a(this.a) != null))
    {
      Object localObject = (ImageView)bgkx.a(this.a).findViewById(2131377595);
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130846218);
        localObject = (TextView)bgkx.a(this.a).findViewById(2131377582);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      bgkx.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new ImportantMessageShortcutBarPanel.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgla
 * JD-Core Version:    0.7.0.1
 */