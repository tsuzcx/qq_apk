import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

class bftf
  implements DialogInterface.OnClickListener
{
  bftf(bftd parambftd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.d();
    if (ReciteRecordLayout.a(this.a.a) != null) {
      ReciteRecordLayout.a(this.a.a).e();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftf
 * JD-Core Version:    0.7.0.1
 */