import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qlink.QlAndQQInterface.DailogClickInfo;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bmjr
  implements DialogInterface.OnClickListener
{
  public bmjr(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.a().a(new QlAndQQInterface.DailogClickInfo(4));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjr
 * JD-Core Version:    0.7.0.1
 */