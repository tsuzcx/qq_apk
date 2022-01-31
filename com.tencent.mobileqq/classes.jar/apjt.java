import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

class apjt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  apjt(apjo paramapjo) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a != null) {
      this.a.a.fullScroll(130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjt
 * JD-Core Version:    0.7.0.1
 */