import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgsy
  implements DialogInterface.OnClickListener
{
  bgsy(bgsx parambgsx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a("later_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsy
 * JD-Core Version:    0.7.0.1
 */