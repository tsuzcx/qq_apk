import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View.OnClickListener;

public abstract class ayem
  extends ClickableSpan
  implements View.OnClickListener
{
  private int a;
  
  public ayem(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.a);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayem
 * JD-Core Version:    0.7.0.1
 */