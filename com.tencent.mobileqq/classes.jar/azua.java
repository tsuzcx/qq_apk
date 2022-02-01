import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class azua
  implements DialogInterface.OnClickListener
{
  public azua(StickyNotePublishFragment paramStickyNotePublishFragment, aztx paramaztx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment.b.obtainMessage(3, this.jdField_a_of_type_Aztx).sendToTarget();
    bdla.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 1, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azua
 * JD-Core Version:    0.7.0.1
 */