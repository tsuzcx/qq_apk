import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bntn
  implements View.OnClickListener
{
  bntn(bntl parambntl) {}
  
  public void onClick(View paramView)
  {
    xwa.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bntl.a(this.a).p) {
      bntl.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bntl.a(this.a).p = false;
      bntl.b(this.a).setSelected(false);
      bntl.a(this.a).c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntn
 * JD-Core Version:    0.7.0.1
 */