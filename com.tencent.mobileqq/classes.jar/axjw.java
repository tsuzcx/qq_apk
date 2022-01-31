import android.view.View;
import android.view.View.OnClickListener;

class axjw
  implements View.OnClickListener
{
  axjw(axjq paramaxjq) {}
  
  public void onClick(View paramView)
  {
    axjq.a(this.a, axjq.a(this.a));
    axjq.b(this.a, System.currentTimeMillis());
    if (axjq.a(this.a) - axjq.b(this.a) < 300L) {
      return;
    }
    axjq.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */