import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class bgcp
  implements DialogInterface.OnClickListener
{
  public bgcp(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.e();
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).e();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcp
 * JD-Core Version:    0.7.0.1
 */