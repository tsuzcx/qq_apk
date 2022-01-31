import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import dov.com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;

public class aonb
  implements View.OnClickListener
{
  public aonb(ShareActionSheet paramShareActionSheet) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonb
 * JD-Core Version:    0.7.0.1
 */