import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class aogt
  implements DialogInterface.OnClickListener
{
  public aogt(VideoBroadcastReceiver paramVideoBroadcastReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogt
 * JD-Core Version:    0.7.0.1
 */