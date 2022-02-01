import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bqzp
  implements DialogInterface.OnClickListener
{
  bqzp(bqzj parambqzj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bqzj.a(this.a).q = false;
    bqzj.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzp
 * JD-Core Version:    0.7.0.1
 */