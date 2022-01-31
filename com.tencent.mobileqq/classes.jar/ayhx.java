import android.view.View;
import android.view.View.OnClickListener;

class ayhx
  implements View.OnClickListener
{
  ayhx(ayhw paramayhw) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ayhr))
    {
      ayhr localayhr = (ayhr)paramView.getTag();
      if ((this.a.a != null) && (localayhr.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhx
 * JD-Core Version:    0.7.0.1
 */