import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

public class bdim
  implements View.OnClickListener
{
  public bdim(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdim
 * JD-Core Version:    0.7.0.1
 */