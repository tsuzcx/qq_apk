import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bize
  implements DialogInterface.OnClickListener
{
  bize(bizc parambizc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((biyy)this.a.a).f(true);
    bizc.a(this.a).setSelected(true);
    ((biyy)this.a.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bize
 * JD-Core Version:    0.7.0.1
 */