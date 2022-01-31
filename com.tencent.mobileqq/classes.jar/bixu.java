import android.view.View;
import android.view.View.OnClickListener;

class bixu
  implements View.OnClickListener
{
  bixu(bixs parambixs) {}
  
  public void onClick(View paramView)
  {
    if (bixs.a(this.a))
    {
      if (bixs.b(this.a)) {
        this.a.dismiss();
      }
      if (bixs.b(this.a) != null) {
        bixs.b(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bixu
 * JD-Core Version:    0.7.0.1
 */