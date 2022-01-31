import android.view.View;
import android.view.View.OnClickListener;

class avwc
  implements View.OnClickListener
{
  avwc(avwb paramavwb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwc
 * JD-Core Version:    0.7.0.1
 */