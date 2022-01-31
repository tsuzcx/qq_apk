import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class aobm
  implements DialogInterface.OnClickListener
{
  public aobm(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipePostTableLayout.a(this.a).isShowing()) {
      SwipePostTableLayout.a(this.a).dismiss();
    }
    aobd.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobm
 * JD-Core Version:    0.7.0.1
 */