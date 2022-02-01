import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqzk
  implements View.OnClickListener
{
  bqzk(bqzj parambqzj) {}
  
  public void onClick(View paramView)
  {
    if (!bqzj.a(this.a).f) {
      bqzj.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bqzj.a(this.a).p)
      {
        bjuh.a().a(2131716927);
        bqzj.a(this.a).p = false;
        bqzj.a(this.a).setSelected(false);
        bqzj.a(this.a).m = false;
        bqzj.a(this.a).c(3008);
      }
      else
      {
        bjuh.a().a(2131716929);
        bqzj.a(this.a).p = true;
        bqzj.a(this.a).setSelected(true);
        bqzj.a(this.a).m = true;
        bqzj.a(this.a).c(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzk
 * JD-Core Version:    0.7.0.1
 */