import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bqbg
  implements DialogInterface.OnCancelListener
{
  bqbg(bqav parambqav) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bqav.b(this.a).R();
    bqav.a(this.a).setVisibility(0);
    if (bqav.a(this.a) != null) {
      bqav.a(this.a).startAnimation(bqav.a(this.a));
    }
    bqav.c(this.a);
    bqav.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbg
 * JD-Core Version:    0.7.0.1
 */