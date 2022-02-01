import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;

public class bmkb
  implements DialogInterface.OnClickListener
{
  public bmkb(AEEditorMultiVideoEditFragment paramAEEditorMultiVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bmbc.a().p();
    this.a.getArguments().putSerializable("resource_model", null);
    this.a.getArguments().putSerializable("resource_model", AEEditorMultiVideoEditFragment.a(this.a));
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkb
 * JD-Core Version:    0.7.0.1
 */