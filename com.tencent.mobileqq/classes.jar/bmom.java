import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bmom
  implements DialogInterface.OnClickListener
{
  bmom(bmoj parambmoj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bmoj.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmom
 * JD-Core Version:    0.7.0.1
 */