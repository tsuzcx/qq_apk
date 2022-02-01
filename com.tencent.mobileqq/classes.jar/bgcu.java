import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

class bgcu
  implements DialogInterface.OnClickListener
{
  bgcu(bgcs parambgcs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.e();
    if (ReciteRecordLayout.a(this.a.a) != null) {
      ReciteRecordLayout.a(this.a.a).e();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcu
 * JD-Core Version:    0.7.0.1
 */