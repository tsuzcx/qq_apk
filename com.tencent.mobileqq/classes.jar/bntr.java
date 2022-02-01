import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bntr
  implements DialogInterface.OnClickListener
{
  bntr(bntl parambntl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bntl.a(this.a).p = false;
    bntl.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntr
 * JD-Core Version:    0.7.0.1
 */