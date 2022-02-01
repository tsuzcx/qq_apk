import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.3.1;
import mqq.os.MqqHandler;

public class bgce
  implements PopupWindow.OnDismissListener
{
  bgce(bgcb parambgcb) {}
  
  public void onDismiss()
  {
    if ((bgcb.a(this.a) != null) && (bgcb.a(this.a) != null))
    {
      Object localObject = (ImageView)bgcb.a(this.a).findViewById(2131377636);
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130846206);
        localObject = (TextView)bgcb.a(this.a).findViewById(2131377623);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      bgcb.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new LeftAppShortcutBarPanel.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgce
 * JD-Core Version:    0.7.0.1
 */