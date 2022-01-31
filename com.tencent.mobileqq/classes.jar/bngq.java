import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bngq
  implements DialogInterface.OnClickListener
{
  bngq(bngl parambngl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bngl.a(this.a).q = true;
    bngl.b(this.a).setSelected(true);
    bngl.a(this.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngq
 * JD-Core Version:    0.7.0.1
 */