import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.download.unite.DownloadDialogFragment;

public class asar
  implements DialogInterface.OnCancelListener
{
  public asar(DownloadDialogFragment paramDownloadDialogFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DownloadDialogFragment.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asar
 * JD-Core Version:    0.7.0.1
 */