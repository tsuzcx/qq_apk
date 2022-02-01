import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beuk
  implements View.OnClickListener
{
  beuk(beuj parambeuj) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == beuj.a(this.a)) && (beuj.a(this.a).app != null) && (beuj.a(this.a) != null))
      {
        Object localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        ImageView localImageView = (ImageView)paramView.findViewById(2131377363);
        if (beuj.a(this.a) != null)
        {
          if (!beuj.a(this.a).a())
          {
            if (beuj.a(this.a).a() > 5) {}
            for (int i = ViewUtils.dip2px(247.0F);; i = ViewUtils.dip2px(beuj.a(this.a).a() * 40 + 7))
            {
              beuj.a(this.a).b(paramView, paramView.getWidth(), 0, localObject[0] - ViewUtils.dip2px(175.0F) / 2, localObject[1] - i);
              localImageView.setImageResource(2130846110);
              localObject = (TextView)beuj.a(this.a).findViewById(2131377350);
              if (localObject == null) {
                break;
              }
              ((TextView)localObject).setVisibility(4);
              break;
            }
          }
          beuj.a(this.a).d();
        }
      }
      else
      {
        beuj.a(this.a).onClick(paramView);
        if (beuj.a(this.a) != null) {
          beuj.a(this.a).a(paramView, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beuk
 * JD-Core Version:    0.7.0.1
 */