import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bntq
  implements DialogInterface.OnClickListener
{
  bntq(bntl parambntl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bntl.a(this.a).p = true;
    bntl.b(this.a).setSelected(true);
    bntl.a(this.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntq
 * JD-Core Version:    0.7.0.1
 */