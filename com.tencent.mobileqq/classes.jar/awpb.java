import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class awpb
  implements DialogInterface.OnClickListener
{
  public awpb(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.b.obtainMessage(3, "").sendToTarget();
    azmj.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 2, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpb
 * JD-Core Version:    0.7.0.1
 */