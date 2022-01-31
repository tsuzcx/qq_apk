import android.view.View;
import android.view.View.OnClickListener;

class bfop
  implements View.OnClickListener
{
  bfop(bfol parambfol) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bfol.a(this.a) != null) {
      bfol.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfop
 * JD-Core Version:    0.7.0.1
 */