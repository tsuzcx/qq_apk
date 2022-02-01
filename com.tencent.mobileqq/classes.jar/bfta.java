import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class bfta
  implements DialogInterface.OnClickListener
{
  public bfta(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d();
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).e();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfta
 * JD-Core Version:    0.7.0.1
 */