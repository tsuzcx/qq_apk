import android.view.View;
import android.view.View.OnClickListener;

class appd
  implements View.OnClickListener
{
  appd(appb paramappb) {}
  
  public void onClick(View paramView)
  {
    if (appb.a(this.a))
    {
      appb.a(this.a);
      return;
    }
    appb.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appd
 * JD-Core Version:    0.7.0.1
 */