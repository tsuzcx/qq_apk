import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bcvr
  implements View.OnClickListener
{
  public bcvr(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvr
 * JD-Core Version:    0.7.0.1
 */