import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bngd
  implements DialogInterface.OnClickListener
{
  bngd(bngb parambngb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bnfx)this.a.a).f(true);
    bngb.a(this.a).setSelected(true);
    ((bnfx)this.a.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngd
 * JD-Core Version:    0.7.0.1
 */