import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.ContainerView;

public class biwj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public biwj(ContainerView paramContainerView) {}
  
  public void onGlobalLayout()
  {
    if (!ContainerView.a(this.a))
    {
      ContainerView.a(this.a, ContainerView.a);
      ContainerView.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwj
 * JD-Core Version:    0.7.0.1
 */