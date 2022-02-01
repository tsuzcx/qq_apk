import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bmkg
  implements DialogInterface.OnClickListener
{
  bmkg(bmkd parambmkd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    bmkd.a(this.a, 2);
    bmkd.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkg
 * JD-Core Version:    0.7.0.1
 */