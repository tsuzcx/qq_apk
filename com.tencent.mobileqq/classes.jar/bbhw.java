import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

class bbhw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bbhw(bbhp parambbhp) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a != null) {
      this.a.a.fullScroll(130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhw
 * JD-Core Version:    0.7.0.1
 */