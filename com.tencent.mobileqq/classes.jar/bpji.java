import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bpji
  implements DialogInterface.OnClickListener
{
  bpji(bpjd parambpjd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bpjd.a(this.a).p = true;
    bpjd.b(this.a).setSelected(true);
    bpjd.a(this.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpji
 * JD-Core Version:    0.7.0.1
 */