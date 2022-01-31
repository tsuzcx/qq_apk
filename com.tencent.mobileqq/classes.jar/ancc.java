import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class ancc
  implements DialogInterface.OnClickListener
{
  public ancc(QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancc
 * JD-Core Version:    0.7.0.1
 */