import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class biab
  implements DialogInterface.OnCancelListener
{
  biab(bhzq parambhzq) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bhzq.b(this.a).T();
    bhzq.a(this.a).setVisibility(0);
    if (bhzq.a(this.a) != null) {
      bhzq.a(this.a).startAnimation(bhzq.a(this.a));
    }
    bhzq.c(this.a);
    bhzq.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biab
 * JD-Core Version:    0.7.0.1
 */