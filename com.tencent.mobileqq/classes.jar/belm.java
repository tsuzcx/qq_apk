import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.FormEditItem;

public class belm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public belm(FormEditItem paramFormEditItem) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    FormEditItem.a(this.a, this.a.getMeasuredWidth());
    FormEditItem.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belm
 * JD-Core Version:    0.7.0.1
 */