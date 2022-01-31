import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class apcv
  extends ClickableSpan
{
  apcv(apcz paramapcz) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcv
 * JD-Core Version:    0.7.0.1
 */