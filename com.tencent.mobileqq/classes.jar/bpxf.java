import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpxf
  implements View.OnClickListener
{
  bpxf(bpxe parambpxe) {}
  
  public void onClick(View paramView)
  {
    yqu.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g()) {
      bpxe.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a().f(false);
      bpxe.a(this.a).setSelected(false);
      this.a.a().c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxf
 * JD-Core Version:    0.7.0.1
 */