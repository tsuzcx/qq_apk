import android.view.View;
import android.view.View.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;

public class bmzf
  implements View.OnClickListener
{
  public bmzf(RateWidgetRatingBar paramRateWidgetRatingBar) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzf
 * JD-Core Version:    0.7.0.1
 */