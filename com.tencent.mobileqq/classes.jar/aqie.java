import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aqie
  extends ClickableSpan
{
  aqie(aqid paramaqid, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aqid.d.c)) {
      bfyi.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    }
    for (;;)
    {
      aqid.a("0X800AE67", this.b, "");
      return;
      bgge.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     aqie
 * JD-Core Version:    0.7.0.1
 */