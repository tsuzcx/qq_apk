import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfkx
  implements View.OnClickListener
{
  bfkx(bfkw parambfkw) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == bfkw.a(this.a)) && (bfkw.a(this.a).a != null) && (bfkw.a(this.a) != null))
      {
        Object localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        ImageView localImageView = (ImageView)paramView.findViewById(2131377441);
        if (bfkw.a(this.a) != null)
        {
          if (!bfkw.a(this.a).a())
          {
            if (bfkw.a(this.a).a() > 5) {}
            for (int i = bgtn.a(247.0F);; i = bgtn.a(bfkw.a(this.a).a() * 40 + 7))
            {
              bfkw.a(this.a).b(paramView, paramView.getWidth(), 0, localObject[0] - bgtn.a(175.0F) / 2, localObject[1] - i);
              localImageView.setImageResource(2130846202);
              localObject = (TextView)bfkw.a(this.a).findViewById(2131377428);
              if (localObject == null) {
                break;
              }
              ((TextView)localObject).setVisibility(4);
              break;
            }
          }
          bfkw.a(this.a).d();
        }
      }
      else
      {
        bfkw.a(this.a).onClick(paramView);
        if (bfkw.a(this.a) != null) {
          bfkw.a(this.a).a(paramView, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkx
 * JD-Core Version:    0.7.0.1
 */