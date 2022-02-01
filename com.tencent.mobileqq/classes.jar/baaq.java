import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;

public class baaq
  implements DialogInterface.OnClickListener
{
  public baaq(StickyNotePublishFragment paramStickyNotePublishFragment, baan parambaan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment.b.obtainMessage(3, this.jdField_a_of_type_Baan).sendToTarget();
    bdll.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 1, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baaq
 * JD-Core Version:    0.7.0.1
 */