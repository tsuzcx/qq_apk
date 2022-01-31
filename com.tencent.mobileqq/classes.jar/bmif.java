import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bmif
  implements DialogInterface.OnCancelListener
{
  bmif(bmhu parambmhu) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bmhu.b(this.a).R();
    bmhu.a(this.a).setVisibility(0);
    if (bmhu.a(this.a) != null) {
      bmhu.a(this.a).startAnimation(bmhu.a(this.a));
    }
    bmhu.c(this.a);
    bmhu.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmif
 * JD-Core Version:    0.7.0.1
 */