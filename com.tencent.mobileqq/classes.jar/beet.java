import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beet
  implements View.OnClickListener
{
  beet(bees parambees) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof been))
    {
      been localbeen = (been)paramView.getTag();
      if ((this.a.a != null) && (localbeen.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beet
 * JD-Core Version:    0.7.0.1
 */