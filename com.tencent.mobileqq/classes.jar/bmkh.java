import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bmkh
  implements DialogInterface.OnClickListener
{
  bmkh(bmkd parambmkd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    bmkd.a(this.a, 1);
    bmkd.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkh
 * JD-Core Version:    0.7.0.1
 */