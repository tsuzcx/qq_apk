import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blll
  implements View.OnClickListener
{
  blll(bllh parambllh) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isPlaying()) {
      this.a.a.pause();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blll
 * JD-Core Version:    0.7.0.1
 */