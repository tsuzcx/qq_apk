import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bntc
  implements View.OnClickListener
{
  bntc(bntb parambntb) {}
  
  public void onClick(View paramView)
  {
    xwa.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g()) {
      bntb.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a().e(false);
      bntb.a(this.a).setSelected(false);
      this.a.a().c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntc
 * JD-Core Version:    0.7.0.1
 */