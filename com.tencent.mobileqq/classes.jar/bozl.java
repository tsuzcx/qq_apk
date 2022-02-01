import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bozl
  implements DialogInterface.OnCancelListener
{
  bozl(boza paramboza) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    boza.b(this.a).R();
    boza.a(this.a).setVisibility(0);
    if (boza.a(this.a) != null) {
      boza.a(this.a).startAnimation(boza.a(this.a));
    }
    boza.c(this.a);
    boza.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozl
 * JD-Core Version:    0.7.0.1
 */