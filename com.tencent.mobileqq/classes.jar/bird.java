import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class bird
  implements View.OnClickListener
{
  bird(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bird
 * JD-Core Version:    0.7.0.1
 */