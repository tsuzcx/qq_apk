import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.TroopGameCardView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgpr
  implements View.OnClickListener
{
  public bgpr(TroopGameCardView paramTroopGameCardView) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Integer)))
    {
      localInteger = (Integer)paramView.getTag();
      if (localInteger.compareTo(TroopGameCardView.a(this.a)) != 0) {
        break label47;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      TroopGameCardView.a(this.a, localInteger);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpr
 * JD-Core Version:    0.7.0.1
 */