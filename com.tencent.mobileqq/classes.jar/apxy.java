import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apxy
  implements View.OnClickListener
{
  public apxy(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      return;
    }
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxy
 * JD-Core Version:    0.7.0.1
 */