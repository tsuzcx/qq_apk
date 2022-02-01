import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bpxh
  implements DialogInterface.OnClickListener
{
  bpxh(bpxe parambpxe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bpxa)this.a.a).f(false);
    bpxe.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxh
 * JD-Core Version:    0.7.0.1
 */