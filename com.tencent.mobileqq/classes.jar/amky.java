import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class amky
  implements DialogInterface.OnClickListener
{
  amky(amkw paramamkw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(amkw.a(this.a), 4, "right button is clicked! ");
    }
    amkw.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amky
 * JD-Core Version:    0.7.0.1
 */