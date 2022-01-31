import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.PopupMenuDialog;

public class amdb
  implements View.OnClickListener
{
  public amdb(PopupMenuDialog paramPopupMenuDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amdb
 * JD-Core Version:    0.7.0.1
 */