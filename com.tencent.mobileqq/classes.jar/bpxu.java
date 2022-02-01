import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bpxu
  implements DialogInterface.OnClickListener
{
  bpxu(bpxo parambpxo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bpxo.a(this.a).q = false;
    bpxo.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxu
 * JD-Core Version:    0.7.0.1
 */