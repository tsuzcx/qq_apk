import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class awcw
  implements DialogInterface.OnClickListener
{
  public awcw(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.clear();
    SignTextEditFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awcw
 * JD-Core Version:    0.7.0.1
 */