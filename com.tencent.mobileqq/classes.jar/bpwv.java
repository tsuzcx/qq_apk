import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import java.lang.ref.WeakReference;

public class bpwv
  implements View.OnClickListener
{
  public bpwv(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      bpwx localbpwx = (bpwx)VideoCoverPickerProviderView.a(this.a).get();
      if (localbpwx != null) {
        localbpwx.a(VideoCoverPickerProviderView.a(this.a), true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwv
 * JD-Core Version:    0.7.0.1
 */