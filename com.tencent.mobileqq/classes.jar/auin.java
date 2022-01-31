import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class auin
  implements DialogInterface.OnClickListener
{
  public auin(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.getActivity().isFinishing()) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auin
 * JD-Core Version:    0.7.0.1
 */