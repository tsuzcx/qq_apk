import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aqyp
  extends ClickableSpan
{
  aqyp(aqyo paramaqyo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aqyo.d.c)) {
      bgrl.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    }
    for (;;)
    {
      aqyo.a("0X800AE67", this.b, "");
      return;
      bgzo.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyp
 * JD-Core Version:    0.7.0.1
 */