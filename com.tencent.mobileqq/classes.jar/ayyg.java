import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayyg
  implements View.OnClickListener
{
  ayyg(ayyc paramayyc) {}
  
  public void onClick(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(ayyc.a(this.a), paramView);
    this.a.a(ayyc.a(this.a).b, localPopupMenu);
    localPopupMenu.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyg
 * JD-Core Version:    0.7.0.1
 */