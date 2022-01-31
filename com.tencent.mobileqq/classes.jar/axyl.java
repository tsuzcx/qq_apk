import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;

public class axyl
  implements DialogInterface.OnClickListener
{
  public axyl(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SignatureEditFragment.a(this.a, 8589934618L, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyl
 * JD-Core Version:    0.7.0.1
 */