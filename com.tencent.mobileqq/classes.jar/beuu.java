import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class beuu
  implements View.OnClickListener
{
  public beuu(ShareActionSheetV2 paramShareActionSheetV2) {}
  
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
 * Qualified Name:     beuu
 * JD-Core Version:    0.7.0.1
 */