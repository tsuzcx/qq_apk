import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;

public class bish
  implements ViewTreeObserver.OnPreDrawListener
{
  public bish(QQBlurView paramQQBlurView) {}
  
  public boolean onPreDraw()
  {
    if (!QQBlurView.a(this.a)) {}
    while (!QQBlurView.a(this.a).a()) {
      return true;
    }
    return QQBlurView.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bish
 * JD-Core Version:    0.7.0.1
 */