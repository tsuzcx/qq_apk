import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgta
  implements DialogInterface.OnClickListener
{
  bgta(bgsz parambgsz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("click");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgta
 * JD-Core Version:    0.7.0.1
 */