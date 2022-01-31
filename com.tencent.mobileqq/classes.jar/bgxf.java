import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgxf
  implements DialogInterface.OnClickListener
{
  bgxf(bgxe parambgxe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a("later_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxf
 * JD-Core Version:    0.7.0.1
 */