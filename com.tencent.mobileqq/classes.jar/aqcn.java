import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aqcn
  implements DialogInterface.OnClickListener
{
  aqcn(aqcl paramaqcl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aqcl.a(this.a, null);
    aqcl.b(this.a, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqcn
 * JD-Core Version:    0.7.0.1
 */