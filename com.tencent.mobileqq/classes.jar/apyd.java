import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apyd
  implements View.OnClickListener
{
  public apyd(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(ajya.a(2131713813));
      return;
    }
    SendBottomBar.a(this.a).e();
    SendBottomBar.a(this.a).setText(ajya.a(2131713825));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apyd
 * JD-Core Version:    0.7.0.1
 */