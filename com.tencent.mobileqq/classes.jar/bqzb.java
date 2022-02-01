import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bqzb
  implements DialogInterface.OnClickListener
{
  bqzb(bqyz parambqyz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bqyv)this.a.a).f(true);
    bqyz.a(this.a).setSelected(true);
    ((bqyv)this.a.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzb
 * JD-Core Version:    0.7.0.1
 */