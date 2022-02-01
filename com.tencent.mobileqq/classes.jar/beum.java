import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMessageShortcutBarPanel.3.1;
import mqq.os.MqqHandler;

public class beum
  implements PopupWindow.OnDismissListener
{
  beum(beuj parambeuj) {}
  
  public void onDismiss()
  {
    if ((beuj.a(this.a) != null) && (beuj.a(this.a) != null))
    {
      Object localObject = (ImageView)beuj.a(this.a).findViewById(2131377363);
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130846111);
        localObject = (TextView)beuj.a(this.a).findViewById(2131377350);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      beuj.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new ImportantMessageShortcutBarPanel.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beum
 * JD-Core Version:    0.7.0.1
 */