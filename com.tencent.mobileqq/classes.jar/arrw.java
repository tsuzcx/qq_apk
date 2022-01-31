import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

public class arrw
  implements DialogInterface.OnClickListener
{
  public arrw(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (FloatingScreenPermission.requestPermission(BaseApplicationImpl.getContext()))
    {
      ListenTogetherOverlayFragment.a(this.a, true);
      return;
    }
    ListenTogetherOverlayFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrw
 * JD-Core Version:    0.7.0.1
 */