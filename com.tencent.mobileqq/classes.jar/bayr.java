import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bayr
  implements DialogInterface.OnDismissListener
{
  public bayr(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TribeVideoListPlayerFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayr
 * JD-Core Version:    0.7.0.1
 */