import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpxq
  implements View.OnClickListener
{
  bpxq(bpxo parambpxo) {}
  
  public void onClick(View paramView)
  {
    yqu.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bpxo.a(this.a).q) {
      bpxo.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bpxo.a(this.a).q = false;
      bpxo.b(this.a).setSelected(false);
      bpxo.a(this.a).c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxq
 * JD-Core Version:    0.7.0.1
 */