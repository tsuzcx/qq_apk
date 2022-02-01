import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class beam
  implements DialogInterface.OnClickListener
{
  beam(bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beam
 * JD-Core Version:    0.7.0.1
 */