import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class bbtk
  implements DialogInterface.OnClickListener
{
  public bbtk(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.clear();
    SignTextEditFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtk
 * JD-Core Version:    0.7.0.1
 */