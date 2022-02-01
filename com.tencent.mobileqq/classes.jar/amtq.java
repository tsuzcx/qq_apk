import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtq
  implements View.OnClickListener
{
  amtq(amtp paramamtp) {}
  
  public void onClick(View paramView)
  {
    if (amtp.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = amtp.a(this.a).a();
    label63:
    amtp localamtp;
    if (bool)
    {
      amtp.a(this.a).setImageDrawable(amtp.a(this.a).getContext().getResources().getDrawable(2130838475));
      localamtp = this.a;
      if (bool) {
        break label133;
      }
    }
    label133:
    for (bool = true;; bool = false)
    {
      amtp.a(localamtp, bool);
      amtp.a(this.a).a(amtp.a(this.a));
      break;
      amtp.a(this.a).setImageDrawable(amtp.a(this.a).getContext().getResources().getDrawable(2130838474));
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */