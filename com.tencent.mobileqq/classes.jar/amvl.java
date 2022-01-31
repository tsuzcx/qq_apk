import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkStandardDialogActivity;

public class amvl
  implements DialogInterface.OnClickListener
{
  public amvl(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQProxyForQlink.a(this.a, 5, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvl
 * JD-Core Version:    0.7.0.1
 */