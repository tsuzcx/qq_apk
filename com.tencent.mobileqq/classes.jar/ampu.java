import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ampu
  implements DialogInterface.OnClickListener
{
  ampu(ampp paramampp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "cancel click");
    }
    bdll.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampu
 * JD-Core Version:    0.7.0.1
 */