import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

class apqg
  implements View.OnClickListener
{
  apqg(apqf paramapqf) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - apqf.a(this.a) > 1000L)
    {
      apqf.a(this.a, l);
      paramView = new Bundle();
      paramView.putInt("AECAMERA_MODE", 202);
      paramView.putInt("VIDEO_STORY_FROM_TYPE", bkwm.i.a());
      bkwq.a((BaseActivity)this.a.a.a, 120, paramView);
      azmj.b(((BaseActivity)this.a.a.a).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqg
 * JD-Core Version:    0.7.0.1
 */