import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit.17;

public class bmxd
  implements View.OnClickListener
{
  public bmxd(AEPituCameraUnit.17 param17) {}
  
  public void onClick(View paramView)
  {
    if (this.a.this$0.a != null) {
      this.a.this$0.a.e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxd
 * JD-Core Version:    0.7.0.1
 */