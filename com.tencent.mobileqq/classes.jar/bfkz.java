import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMessageShortcutBarPanel.3.1;
import mqq.os.MqqHandler;

public class bfkz
  implements PopupWindow.OnDismissListener
{
  bfkz(bfkw parambfkw) {}
  
  public void onDismiss()
  {
    if ((bfkw.a(this.a) != null) && (bfkw.a(this.a) != null))
    {
      Object localObject = (ImageView)bfkw.a(this.a).findViewById(2131377441);
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130846203);
        localObject = (TextView)bfkw.a(this.a).findViewById(2131377428);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      bfkw.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new ImportantMessageShortcutBarPanel.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkz
 * JD-Core Version:    0.7.0.1
 */