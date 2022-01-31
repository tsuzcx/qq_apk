import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;

public class avlg
  implements DialogInterface.OnClickListener
{
  public avlg(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */