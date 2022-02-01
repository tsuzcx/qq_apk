import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bqzo
  implements DialogInterface.OnClickListener
{
  bqzo(bqzj parambqzj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bqzj.a(this.a).q = true;
    bqzj.b(this.a).setSelected(true);
    bqzj.a(this.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzo
 * JD-Core Version:    0.7.0.1
 */