import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;

public class bbmo
  implements ViewTreeObserver.OnPreDrawListener
{
  public bbmo(QQBlurView paramQQBlurView) {}
  
  public boolean onPreDraw()
  {
    if (!QQBlurView.a(this.a)) {
      return true;
    }
    return QQBlurView.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbmo
 * JD-Core Version:    0.7.0.1
 */