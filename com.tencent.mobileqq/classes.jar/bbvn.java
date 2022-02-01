import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View.OnClickListener;

public abstract class bbvn
  extends ClickableSpan
  implements View.OnClickListener
{
  private int a;
  
  public bbvn(int paramInt)
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
 * Qualified Name:     bbvn
 * JD-Core Version:    0.7.0.1
 */