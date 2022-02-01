import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tavcut.exporter.ImageExporter;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.19;

public class boep
  implements DialogInterface.OnDismissListener
{
  public boep(AEEditorImageEditFragment.19 param19) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AEEditorImageEditFragment.a(this.a.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boep
 * JD-Core Version:    0.7.0.1
 */