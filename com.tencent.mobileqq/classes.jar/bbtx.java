import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;

public class bbtx
  implements DialogInterface.OnClickListener
{
  public bbtx(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bbux.a().a(bbux.a().b);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtx
 * JD-Core Version:    0.7.0.1
 */