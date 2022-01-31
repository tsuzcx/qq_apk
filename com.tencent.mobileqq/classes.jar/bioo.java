import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bioo
  implements DialogInterface.OnClickListener
{
  bioo(bioj parambioj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("0X8004857", 1);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bioo
 * JD-Core Version:    0.7.0.1
 */