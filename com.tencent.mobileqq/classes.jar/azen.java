import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azen
  implements View.OnClickListener
{
  azen(azej paramazej) {}
  
  public void onClick(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(azej.a(this.a), paramView);
    this.a.a(azej.a(this.a).b, localPopupMenu);
    localPopupMenu.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azen
 * JD-Core Version:    0.7.0.1
 */