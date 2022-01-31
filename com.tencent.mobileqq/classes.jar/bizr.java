import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bizr
  implements DialogInterface.OnClickListener
{
  bizr(bizm parambizm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bizm.a(this.a).q = true;
    bizm.b(this.a).setSelected(true);
    bizm.a(this.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizr
 * JD-Core Version:    0.7.0.1
 */