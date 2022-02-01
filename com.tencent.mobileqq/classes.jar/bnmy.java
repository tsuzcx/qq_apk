import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bnmy
  implements DialogInterface.OnClickListener
{
  bnmy(bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmy
 * JD-Core Version:    0.7.0.1
 */