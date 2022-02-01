import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class anzu
  implements DialogInterface.OnClickListener
{
  anzu(QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bdll.b(this.a, "CliOper", "", "", "0X8004C6C", "0X8004C6C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzu
 * JD-Core Version:    0.7.0.1
 */