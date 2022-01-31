import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aplb
  implements View.OnClickListener
{
  aplb(apla paramapla) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.hideSoftInputFromWindow();
    apla.a(this.a, apla.a(this.a).uniseq);
    this.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplb
 * JD-Core Version:    0.7.0.1
 */