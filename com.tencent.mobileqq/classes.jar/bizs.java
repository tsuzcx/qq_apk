import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bizs
  implements DialogInterface.OnClickListener
{
  bizs(bizm parambizm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bizm.a(this.a).q = false;
    bizm.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizs
 * JD-Core Version:    0.7.0.1
 */