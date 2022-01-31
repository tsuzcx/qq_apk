import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qlink.QlAndQQInterface.DailogClickInfo;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bgot
  implements DialogInterface.OnClickListener
{
  public bgot(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.a().a(new QlAndQQInterface.DailogClickInfo(4));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgot
 * JD-Core Version:    0.7.0.1
 */