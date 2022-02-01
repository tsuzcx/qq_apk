import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aroh
  extends ClickableSpan
{
  aroh(arof paramarof, String paramString) {}
  
  public void onClick(View paramView)
  {
    bhrn.a(arof.a(this.jdField_a_of_type_Arof), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    arof.a("0X800AE6D", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroh
 * JD-Core Version:    0.7.0.1
 */