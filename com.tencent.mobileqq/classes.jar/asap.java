import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.download.unite.DownloadDialogFragment;

public class asap
  implements DialogInterface.OnClickListener
{
  public asap(DownloadDialogFragment paramDownloadDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadDialogFragment.a(this.a, 1);
    DownloadDialogFragment.a(this.a.getActivity());
    azcl.a("0X800B53C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asap
 * JD-Core Version:    0.7.0.1
 */