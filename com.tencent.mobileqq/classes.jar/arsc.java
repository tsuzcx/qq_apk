import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class arsc
  extends ClickableSpan
{
  arsc(arsg paramarsg) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsc
 * JD-Core Version:    0.7.0.1
 */