import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class anyq
  implements View.OnClickListener
{
  public anyq(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.b > 1000L)
    {
      this.a.b = l;
      paramView = new Bundle();
      paramView.putInt("AECAMERA_MODE", 202);
      paramView.putInt("VIDEO_STORY_FROM_TYPE", birt.i.a());
      birx.a((BaseActivity)this.a.a, 120, paramView);
      axqy.b(((BaseActivity)this.a.a).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyq
 * JD-Core Version:    0.7.0.1
 */