import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import java.lang.ref.WeakReference;

public class bhqr
  implements View.OnClickListener
{
  public bhqr(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      paramView = (bhqt)VideoCoverPickerProviderView.a(this.a).get();
      if (paramView != null) {
        paramView.a(VideoCoverPickerProviderView.a(this.a), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhqr
 * JD-Core Version:    0.7.0.1
 */