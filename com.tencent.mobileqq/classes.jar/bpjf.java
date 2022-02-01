import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpjf
  implements View.OnClickListener
{
  bpjf(bpjd parambpjd) {}
  
  public void onClick(View paramView)
  {
    ykv.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bpjd.a(this.a).p) {
      bpjd.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bpjd.a(this.a).p = false;
      bpjd.b(this.a).setSelected(false);
      bpjd.a(this.a).c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjf
 * JD-Core Version:    0.7.0.1
 */