import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class bqgz
  implements View.OnClickListener
{
  bqgz(bqgy parambqgy) {}
  
  public void onClick(View paramView)
  {
    if (bqgy.a(this.a) != null)
    {
      if ((bqgy.a(this.a).b() != 1) || (bqgy.a(this.a) != 1)) {
        break label71;
      }
      bqgy.a(this.a);
      bqgy.a(this.a).setImageResource(2130847694);
      bqgy.a(this.a, 2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label71:
      if ((bqgy.a(this.a).b() == 2) && (bqgy.a(this.a) == 2))
      {
        bqgy.b(this.a);
        bqgy.a(this.a).setImageResource(2130847695);
        bqgy.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgz
 * JD-Core Version:    0.7.0.1
 */