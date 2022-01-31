import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arvo
  implements View.OnClickListener
{
  public arvo(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(alud.a(2131714197));
      return;
    }
    SendBottomBar.a(this.a).e();
    SendBottomBar.a(this.a).setText(alud.a(2131714209));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvo
 * JD-Core Version:    0.7.0.1
 */