import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class anlk
  implements View.OnClickListener
{
  anlk(anlh paramanlh) {}
  
  public void onClick(View paramView)
  {
    abvm.a(anlh.a(this.a), -3, "user canceled");
    anlh.a(this.a).a();
    anlh.a(this.a).dismiss();
    anlh.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlk
 * JD-Core Version:    0.7.0.1
 */