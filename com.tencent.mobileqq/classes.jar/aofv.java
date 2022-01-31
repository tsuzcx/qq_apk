import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class aofv
  implements DialogInterface.OnClickListener
{
  public aofv(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipePostTableLayout.a(this.a).isShowing()) {
      SwipePostTableLayout.a(this.a).dismiss();
    }
    aofm.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofv
 * JD-Core Version:    0.7.0.1
 */