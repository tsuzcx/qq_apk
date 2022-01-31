import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bjxk
  implements DialogInterface.OnClickListener
{
  bjxk(bdjz parambdjz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxk
 * JD-Core Version:    0.7.0.1
 */