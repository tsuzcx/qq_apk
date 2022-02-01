import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class bpfe
  implements View.OnClickListener
{
  bpfe(bpfd parambpfd) {}
  
  public void onClick(View paramView)
  {
    if (bpfd.a(this.a) != null)
    {
      if ((bpfd.a(this.a).b() != 1) || (bpfd.a(this.a) != 1)) {
        break label71;
      }
      bpfd.a(this.a);
      bpfd.a(this.a).setImageResource(2130847675);
      bpfd.a(this.a, 2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label71:
      if ((bpfd.a(this.a).b() == 2) && (bpfd.a(this.a) == 2))
      {
        bpfd.b(this.a);
        bpfd.a(this.a).setImageResource(2130847676);
        bpfd.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfe
 * JD-Core Version:    0.7.0.1
 */