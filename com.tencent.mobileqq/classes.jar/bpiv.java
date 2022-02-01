import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bpiv
  implements DialogInterface.OnClickListener
{
  bpiv(bpit parambpit) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bpip)this.a.a).e(true);
    bpit.a(this.a).setSelected(true);
    ((bpip)this.a.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpiv
 * JD-Core Version:    0.7.0.1
 */