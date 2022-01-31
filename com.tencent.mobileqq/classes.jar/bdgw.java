import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;

public class bdgw
  implements DialogInterface.OnClickListener
{
  public bdgw(DownloadNativeApi.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      bdgu.a(this.a.this$0).onDownloadCancel(this.a.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgw
 * JD-Core Version:    0.7.0.1
 */