import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class amgj
  implements DialogInterface.OnClickListener
{
  amgj(amgh paramamgh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(amgh.a(this.a), 4, "right button is clicked! ");
    }
    amgh.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgj
 * JD-Core Version:    0.7.0.1
 */