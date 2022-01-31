import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class auxp
  implements DialogInterface.OnClickListener
{
  public auxp(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.b.obtainMessage(3, "").sendToTarget();
    axqy.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 2, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxp
 * JD-Core Version:    0.7.0.1
 */