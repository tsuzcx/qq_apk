import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgxh
  implements DialogInterface.OnClickListener
{
  bgxh(bgxg parambgxg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("click");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxh
 * JD-Core Version:    0.7.0.1
 */