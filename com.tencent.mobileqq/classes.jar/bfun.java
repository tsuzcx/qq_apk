import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;

public class bfun
  implements DialogInterface.OnClickListener
{
  public bfun(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfun
 * JD-Core Version:    0.7.0.1
 */