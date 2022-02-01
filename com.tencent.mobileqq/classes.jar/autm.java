import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

public class autm
  implements DialogInterface.OnClickListener
{
  public autm(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(false);
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autm
 * JD-Core Version:    0.7.0.1
 */