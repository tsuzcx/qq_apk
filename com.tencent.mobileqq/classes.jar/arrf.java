import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arrf
  implements View.OnClickListener
{
  public arrf(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(alpo.a(2131714185));
      return;
    }
    SendBottomBar.a(this.a).e();
    SendBottomBar.a(this.a).setText(alpo.a(2131714197));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrf
 * JD-Core Version:    0.7.0.1
 */