import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class blck
  implements DialogInterface.OnDismissListener
{
  public blck(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AETakeFacePhotoPreviewFragment.a(this.a);
    AEVideoShelfEditFragment.a(this.a.getActivity(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blck
 * JD-Core Version:    0.7.0.1
 */