import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class bmhj
  implements DialogInterface.OnClickListener
{
  public bmhj(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorVideoClipFragment.b(this.a);
    AEEditorVideoClipFragment.c(this.a);
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhj
 * JD-Core Version:    0.7.0.1
 */