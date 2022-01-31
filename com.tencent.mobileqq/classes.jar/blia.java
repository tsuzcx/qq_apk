import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class blia
  implements DialogInterface.OnClickListener
{
  public blia(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorVideoClipFragment.a(this.a);
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blia
 * JD-Core Version:    0.7.0.1
 */