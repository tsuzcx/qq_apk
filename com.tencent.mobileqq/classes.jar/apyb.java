import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apyb
  implements View.OnClickListener
{
  public apyb(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(ajyc.a(2131713802));
      return;
    }
    SendBottomBar.a(this.a).e();
    SendBottomBar.a(this.a).setText(ajyc.a(2131713814));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apyb
 * JD-Core Version:    0.7.0.1
 */