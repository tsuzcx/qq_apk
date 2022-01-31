import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

final class bdbl
  extends TextView
{
  bdbl(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.b();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbl
 * JD-Core Version:    0.7.0.1
 */