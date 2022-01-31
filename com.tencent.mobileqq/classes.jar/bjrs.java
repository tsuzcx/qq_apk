import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bjrs
  implements DialogInterface.OnCancelListener
{
  bjrs(bjrh parambjrh) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bjrh.b(this.a).R();
    bjrh.a(this.a).setVisibility(0);
    if (bjrh.a(this.a) != null) {
      bjrh.a(this.a).startAnimation(bjrh.a(this.a));
    }
    bjrh.c(this.a);
    bjrh.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrs
 * JD-Core Version:    0.7.0.1
 */