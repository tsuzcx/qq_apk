import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.ContainerView;

public class bind
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bind(ContainerView paramContainerView) {}
  
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
 * Qualified Name:     bind
 * JD-Core Version:    0.7.0.1
 */