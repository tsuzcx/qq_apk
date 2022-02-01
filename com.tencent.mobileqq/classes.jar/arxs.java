import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arxs
  implements View.OnClickListener
{
  arxs(arxr paramarxr) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - arxr.a(this.a) > 1000L)
    {
      arxr.a(this.a, l);
      Bundle localBundle = new Bundle();
      localBundle.putInt("AECAMERA_MODE", 202);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", bnqb.i.a());
      bnqf.a((BaseActivity)this.a.a.a, 120, localBundle);
      bcst.b(((BaseActivity)this.a.a.a).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxs
 * JD-Core Version:    0.7.0.1
 */