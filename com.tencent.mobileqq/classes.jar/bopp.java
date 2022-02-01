import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import java.lang.ref.WeakReference;

public class bopp
  implements View.OnClickListener
{
  public bopp(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      bopr localbopr = (bopr)VideoCoverPickerProviderView.a(this.a).get();
      if (localbopr != null) {
        localbopr.a(VideoCoverPickerProviderView.a(this.a), true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopp
 * JD-Core Version:    0.7.0.1
 */