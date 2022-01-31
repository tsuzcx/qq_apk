import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import java.lang.ref.WeakReference;

public class bjmb
  implements View.OnClickListener
{
  public bjmb(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      paramView = (bjmc)VideoCoverPickerProviderView.a(this.a).get();
      if (paramView != null) {
        paramView.a(VideoCoverPickerProviderView.b(this.a), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmb
 * JD-Core Version:    0.7.0.1
 */