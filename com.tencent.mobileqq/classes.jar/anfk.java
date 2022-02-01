import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anfk
  implements View.OnClickListener
{
  anfk(anfj paramanfj) {}
  
  public void onClick(View paramView)
  {
    if (anfj.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = anfj.a(this.a).a();
    label63:
    anfj localanfj;
    if (bool)
    {
      anfj.a(this.a).setImageDrawable(anfj.a(this.a).getContext().getResources().getDrawable(2130838488));
      localanfj = this.a;
      if (bool) {
        break label133;
      }
    }
    label133:
    for (bool = true;; bool = false)
    {
      anfj.a(localanfj, bool);
      anfj.a(this.a).a(anfj.a(this.a));
      break;
      anfj.a(this.a).setImageDrawable(anfj.a(this.a).getContext().getResources().getDrawable(2130838487));
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfk
 * JD-Core Version:    0.7.0.1
 */