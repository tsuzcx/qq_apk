import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.widget.immersive.SoftInputResizeLayout;

public class amlx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public amlx(SoftInputResizeLayout paramSoftInputResizeLayout) {}
  
  public void onGlobalLayout()
  {
    SoftInputResizeLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlx
 * JD-Core Version:    0.7.0.1
 */