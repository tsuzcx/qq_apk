import android.view.View;
import android.view.View.OnClickListener;

class bjca
  implements View.OnClickListener
{
  bjca(bjbz parambjbz) {}
  
  public void onClick(View paramView)
  {
    if (bjbz.a(this.a))
    {
      if (bjbz.b(this.a)) {
        this.a.dismiss();
      }
      if (bjbz.a(this.a) != null) {
        bjbz.a(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjca
 * JD-Core Version:    0.7.0.1
 */