import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bqzc
  implements DialogInterface.OnClickListener
{
  bqzc(bqyz parambqyz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bqyv)this.a.a).f(false);
    bqyz.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzc
 * JD-Core Version:    0.7.0.1
 */