import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.AECamera.qudong.AEVideoShelfPreviewFragment;

public class bhbh
  implements DialogInterface.OnCancelListener
{
  public bhbh(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfPreviewFragment.a(this.a).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhbh
 * JD-Core Version:    0.7.0.1
 */