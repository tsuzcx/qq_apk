import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10;
import cooperation.wadl.ipc.WadlParams;

public class anet
  implements DialogInterface.OnClickListener
{
  public anet(ArkAppDownloadModule.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    azmj.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", this.a.a.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anet
 * JD-Core Version:    0.7.0.1
 */