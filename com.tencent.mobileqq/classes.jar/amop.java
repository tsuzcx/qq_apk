import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class amop
  implements DialogInterface.OnClickListener
{
  public amop(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    DatalineRemoteManager.a(this.a, 1);
    DatalineRemoteManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amop
 * JD-Core Version:    0.7.0.1
 */