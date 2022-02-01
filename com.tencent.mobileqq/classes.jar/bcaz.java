import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class bcaz
  extends ClickableSpan
{
  public bcaz(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.openContextMenu(this.a.a);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaz
 * JD-Core Version:    0.7.0.1
 */