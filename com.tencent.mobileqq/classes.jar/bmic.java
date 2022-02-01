import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tavcut.exporter.ImageExporter;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.20;

public class bmic
  implements DialogInterface.OnDismissListener
{
  public bmic(AEEditorImageEditFragment.20 param20) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AEEditorImageEditFragment.a(this.a.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmic
 * JD-Core Version:    0.7.0.1
 */