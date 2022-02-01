import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bntd
  implements DialogInterface.OnClickListener
{
  bntd(bntb parambntb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bnsx)this.a.a).e(true);
    bntb.a(this.a).setSelected(true);
    ((bnsx)this.a.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntd
 * JD-Core Version:    0.7.0.1
 */