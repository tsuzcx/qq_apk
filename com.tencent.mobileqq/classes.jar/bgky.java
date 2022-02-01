import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgky
  implements View.OnClickListener
{
  bgky(bgkx parambgkx) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == bgkx.a(this.a)) && (bgkx.a(this.a).a != null) && (bgkx.a(this.a) != null))
      {
        Object localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        ImageView localImageView = (ImageView)paramView.findViewById(2131377595);
        if (bgkx.a(this.a) != null)
        {
          if (!bgkx.a(this.a).a())
          {
            if (bgkx.a(this.a).a() > 5) {}
            for (int i = bhtq.a(247.0F);; i = bhtq.a(bgkx.a(this.a).a() * 40 + 7))
            {
              bgkx.a(this.a).b(paramView, paramView.getWidth(), 0, localObject[0] - bhtq.a(175.0F) / 2, localObject[1] - i);
              localImageView.setImageResource(2130846217);
              localObject = (TextView)bgkx.a(this.a).findViewById(2131377582);
              if (localObject == null) {
                break;
              }
              ((TextView)localObject).setVisibility(4);
              break;
            }
          }
          bgkx.a(this.a).d();
        }
      }
      else
      {
        bgkx.a(this.a).onClick(paramView);
        if (bgkx.a(this.a) != null) {
          bgkx.a(this.a).a(paramView, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgky
 * JD-Core Version:    0.7.0.1
 */