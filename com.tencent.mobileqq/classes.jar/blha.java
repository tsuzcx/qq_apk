import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class blha
  implements DialogInterface.OnCancelListener
{
  public blha(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfEditFragment.a(this.a).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blha
 * JD-Core Version:    0.7.0.1
 */