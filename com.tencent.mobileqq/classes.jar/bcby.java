import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class bcby
  implements DialogInterface.OnClickListener
{
  public bcby(ReciteFragment paramReciteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a(false);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcby
 * JD-Core Version:    0.7.0.1
 */