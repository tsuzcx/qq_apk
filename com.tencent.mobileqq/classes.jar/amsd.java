import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class amsd
  implements DialogInterface.OnClickListener
{
  amsd(amsb paramamsb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(amsb.a(this.a), 4, "right button is clicked! ");
    }
    amsb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */