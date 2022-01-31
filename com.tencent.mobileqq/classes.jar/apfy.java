import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apfy
  implements View.OnClickListener
{
  public apfy(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(ajjy.a(2131648015));
      return;
    }
    SendBottomBar.a(this.a).e();
    SendBottomBar.a(this.a).setText(ajjy.a(2131648027));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfy
 * JD-Core Version:    0.7.0.1
 */