import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment;

public class bhap
  implements DialogInterface.OnDismissListener
{
  public bhap(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AETakeFacePhotoPreviewFragment.a(this.a);
    AEVideoShelfEditFragment.a(this.a.getActivity(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhap
 * JD-Core Version:    0.7.0.1
 */