import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class audv
  implements DialogInterface.OnClickListener
{
  audv(audt paramaudt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    audt.a(this.a, null);
    audt.b(this.a, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audv
 * JD-Core Version:    0.7.0.1
 */