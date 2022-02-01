import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqzl
  implements View.OnClickListener
{
  bqzl(bqzj parambqzj) {}
  
  public void onClick(View paramView)
  {
    yup.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bqzj.a(this.a).q) {
      bqzj.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bqzj.a(this.a).q = false;
      bqzj.b(this.a).setSelected(false);
      bqzj.a(this.a).c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzl
 * JD-Core Version:    0.7.0.1
 */