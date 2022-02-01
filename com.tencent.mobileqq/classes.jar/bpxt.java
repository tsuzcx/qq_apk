import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bpxt
  implements DialogInterface.OnClickListener
{
  bpxt(bpxo parambpxo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bpxo.a(this.a).q = true;
    bpxo.b(this.a).setSelected(true);
    bpxo.a(this.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxt
 * JD-Core Version:    0.7.0.1
 */