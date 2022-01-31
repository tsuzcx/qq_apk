import android.view.View;
import android.view.View.OnClickListener;

class axht
  implements View.OnClickListener
{
  axht(axhs paramaxhs) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof axhn))
    {
      axhn localaxhn = (axhn)paramView.getTag();
      if ((this.a.a != null) && (localaxhn.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axht
 * JD-Core Version:    0.7.0.1
 */