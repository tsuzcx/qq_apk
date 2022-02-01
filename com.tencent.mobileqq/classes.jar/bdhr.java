import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bdhr
  implements DialogInterface.OnClickListener
{
  bdhr(bgpa parambgpa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhr
 * JD-Core Version:    0.7.0.1
 */