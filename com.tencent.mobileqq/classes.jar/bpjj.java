import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bpjj
  implements DialogInterface.OnClickListener
{
  bpjj(bpjd parambpjd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bpjd.a(this.a).p = false;
    bpjd.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjj
 * JD-Core Version:    0.7.0.1
 */