import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class bjsj
  implements DialogInterface.OnCancelListener
{
  bjsj(bjry parambjry) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bjry.b(this.a).R();
    bjry.a(this.a).setVisibility(0);
    if (bjry.a(this.a) != null) {
      bjry.a(this.a).startAnimation(bjry.a(this.a));
    }
    bjry.c(this.a);
    bjry.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsj
 * JD-Core Version:    0.7.0.1
 */