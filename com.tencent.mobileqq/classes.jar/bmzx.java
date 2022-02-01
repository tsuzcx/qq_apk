import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import java.lang.ref.WeakReference;

public class bmzx
  implements View.OnClickListener
{
  public bmzx(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      bmzz localbmzz = (bmzz)VideoCoverPickerProviderView.a(this.a).get();
      if (localbmzz != null) {
        localbmzz.a(VideoCoverPickerProviderView.a(this.a), true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzx
 * JD-Core Version:    0.7.0.1
 */