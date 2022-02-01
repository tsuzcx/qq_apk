import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class awge
  implements DialogInterface.OnClickListener
{
  public awge(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ListenTogetherOverlayFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awge
 * JD-Core Version:    0.7.0.1
 */