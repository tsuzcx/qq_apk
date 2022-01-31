import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class amkp
  implements DialogInterface.OnClickListener
{
  public amkp(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipePostTableLayout.a(this.a).isShowing()) {
      SwipePostTableLayout.a(this.a).dismiss();
    }
    amkg.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkp
 * JD-Core Version:    0.7.0.1
 */