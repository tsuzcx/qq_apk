import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

@TargetApi(21)
public class bctn
  extends ViewOutlineProvider
{
  private float a;
  
  public bctn(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    paramOutline.setRoundRect(new Rect(0, 0, localRect.right - localRect.left - 0, localRect.bottom - localRect.top - 0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bctn
 * JD-Core Version:    0.7.0.1
 */