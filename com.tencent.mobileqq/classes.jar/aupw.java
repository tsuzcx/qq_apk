import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class aupw
  implements DialogInterface.OnClickListener
{
  public aupw(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupw
 * JD-Core Version:    0.7.0.1
 */