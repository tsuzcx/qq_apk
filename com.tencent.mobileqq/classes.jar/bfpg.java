import android.view.View;
import android.view.View.OnClickListener;

class bfpg
  implements View.OnClickListener
{
  bfpg(bfpc parambfpc) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bfpc.a(this.a) != null) {
      bfpc.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfpg
 * JD-Core Version:    0.7.0.1
 */