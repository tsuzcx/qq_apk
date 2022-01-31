import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apfv
  implements View.OnClickListener
{
  public apfv(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.b(this.a, true);
      apci.a("0X800942B");
      return;
    }
    SendBottomBar.c(this.a, false);
    SendBottomBar.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfv
 * JD-Core Version:    0.7.0.1
 */