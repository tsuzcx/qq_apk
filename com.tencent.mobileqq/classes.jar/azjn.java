import android.view.View;
import android.view.View.OnClickListener;

class azjn
  implements View.OnClickListener
{
  azjn(azjh paramazjh) {}
  
  public void onClick(View paramView)
  {
    azjh.a(this.a, azjh.a(this.a));
    azjh.b(this.a, System.currentTimeMillis());
    if (azjh.a(this.a) - azjh.b(this.a) < 300L) {
      return;
    }
    azjh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjn
 * JD-Core Version:    0.7.0.1
 */