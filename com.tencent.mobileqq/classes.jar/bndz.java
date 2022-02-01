import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit.13;

public class bndz
  implements View.OnClickListener
{
  public bndz(AEPituCameraUnit.13 param13) {}
  
  public void onClick(View paramView)
  {
    if (bndy.a(this.a.this$0) != null) {
      bndy.a(this.a.this$0).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndz
 * JD-Core Version:    0.7.0.1
 */