import android.view.View;
import android.view.View.OnClickListener;

class bbjm
  implements View.OnClickListener
{
  bbjm(bbjl parambbjl) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjm
 * JD-Core Version:    0.7.0.1
 */