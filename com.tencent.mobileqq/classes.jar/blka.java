import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit.15;

public class blka
  implements View.OnClickListener
{
  public blka(AEPituCameraUnit.15 param15) {}
  
  public void onClick(View paramView)
  {
    if (this.a.this$0.a != null) {
      this.a.this$0.a.e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blka
 * JD-Core Version:    0.7.0.1
 */