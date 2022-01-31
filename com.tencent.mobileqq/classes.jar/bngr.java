import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bngr
  implements DialogInterface.OnClickListener
{
  bngr(bngl parambngl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bngl.a(this.a).q = false;
    bngl.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngr
 * JD-Core Version:    0.7.0.1
 */