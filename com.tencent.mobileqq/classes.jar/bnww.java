import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;
import java.io.File;

public class bnww
  implements DialogInterface.OnCancelListener
{
  public bnww(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfPreviewFragment.a(this.a).cancelSave();
    paramDialogInterface = new File(AEVideoShelfPreviewFragment.a(this.a).getOutputVideoPath());
    if (paramDialogInterface.exists())
    {
      TTPTLogger.i(AEVideoShelfPreviewFragment.b(), "delete temp silent video");
      paramDialogInterface.delete();
    }
    AEVideoShelfPreviewFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnww
 * JD-Core Version:    0.7.0.1
 */