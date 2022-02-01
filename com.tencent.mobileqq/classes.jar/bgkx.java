import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

final class bgkx
  extends TextView
{
  bgkx(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkx
 * JD-Core Version:    0.7.0.1
 */