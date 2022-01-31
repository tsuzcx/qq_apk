import android.view.View;
import android.view.View.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar.OnRatingChangeListener;

public class anlt
  implements View.OnClickListener
{
  public anlt(RateWidgetRatingBar paramRateWidgetRatingBar) {}
  
  public void onClick(View paramView)
  {
    if (RateWidgetRatingBar.a(this.a))
    {
      this.a.setStar(this.a.indexOfChild(paramView) + 1.0F);
      if (RateWidgetRatingBar.a(this.a) != null) {
        RateWidgetRatingBar.a(this.a).b(this.a.indexOfChild(paramView) + 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anlt
 * JD-Core Version:    0.7.0.1
 */