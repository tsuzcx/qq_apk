import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

class bccm
  implements DialogInterface.OnClickListener
{
  bccm(bcck parambcck) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.c();
    if (ReciteRecordLayout.a(this.a.a) != null) {
      ReciteRecordLayout.a(this.a.a).e();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccm
 * JD-Core Version:    0.7.0.1
 */