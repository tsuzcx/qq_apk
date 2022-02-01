import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class azgv
  implements DialogInterface.OnClickListener
{
  public azgv(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.getActivity().isFinishing()) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgv
 * JD-Core Version:    0.7.0.1
 */