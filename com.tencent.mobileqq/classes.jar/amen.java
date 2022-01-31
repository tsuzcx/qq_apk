import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.widget.immersive.SoftInputResizeLayout;

public class amen
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public amen(SoftInputResizeLayout paramSoftInputResizeLayout) {}
  
  public void onGlobalLayout()
  {
    SoftInputResizeLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amen
 * JD-Core Version:    0.7.0.1
 */