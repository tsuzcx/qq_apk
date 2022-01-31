import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

class augp
  implements View.OnClickListener
{
  augp(augl paramaugl) {}
  
  public void onClick(View paramView)
  {
    paramView = new PopupMenu(augl.a(this.a), paramView);
    this.a.a(augl.a(this.a).b, paramView);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augp
 * JD-Core Version:    0.7.0.1
 */