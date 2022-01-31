import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QZoneShareActivity.3.2;

public class bgcw
  implements DialogInterface.OnClickListener
{
  public bgcw(QZoneShareActivity.3.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("QZoneShare", 1, "dialog click ");
    this.a.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgcw
 * JD-Core Version:    0.7.0.1
 */