import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;

public class betu
  implements ViewTreeObserver.OnPreDrawListener
{
  public betu(QQBlurView paramQQBlurView) {}
  
  public boolean onPreDraw()
  {
    if (!QQBlurView.a(this.a)) {}
    while (!QQBlurView.a(this.a).a()) {
      return true;
    }
    return QQBlurView.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betu
 * JD-Core Version:    0.7.0.1
 */