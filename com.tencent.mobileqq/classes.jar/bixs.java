import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;

public class bixs
  implements DialogInterface.OnCancelListener
{
  public bixs(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfPreviewFragment.a(this.a).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixs
 * JD-Core Version:    0.7.0.1
 */