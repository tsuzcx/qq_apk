import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bpxg
  implements DialogInterface.OnClickListener
{
  bpxg(bpxe parambpxe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bpxa)this.a.a).f(true);
    bpxe.a(this.a).setSelected(true);
    ((bpxa)this.a.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxg
 * JD-Core Version:    0.7.0.1
 */