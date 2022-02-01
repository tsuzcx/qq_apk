import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class bpdk
  implements View.OnClickListener
{
  public bpdk(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public void onClick(View paramView)
  {
    bpam.a("LyricWithBuoyView", "LyricWithBuoyView onClick()");
    if (LyricWithBuoyView.a(this.a) != null) {
      LyricWithBuoyView.a(this.a).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bpam.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdk
 * JD-Core Version:    0.7.0.1
 */