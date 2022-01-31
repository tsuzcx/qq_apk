import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bmdt
  implements DialogInterface.OnCancelListener
{
  bmdt(bmdi parambmdi) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bmdi.b(this.a).R();
    bmdi.a(this.a).setVisibility(0);
    if (bmdi.a(this.a) != null) {
      bmdi.a(this.a).startAnimation(bmdi.a(this.a));
    }
    bmdi.c(this.a);
    bmdi.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdt
 * JD-Core Version:    0.7.0.1
 */