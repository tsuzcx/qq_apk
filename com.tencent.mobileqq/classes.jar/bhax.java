import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment;

public class bhax
  implements DialogInterface.OnCancelListener
{
  public bhax(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfEditFragment.a(this.a).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhax
 * JD-Core Version:    0.7.0.1
 */