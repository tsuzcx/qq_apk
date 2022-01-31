import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class amyu
  extends ClickableSpan
{
  amyu(amyt paramamyt, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    bbje.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (Activity)this.jdField_a_of_type_AndroidContentContext);
    axqy.b(null, "dc00898", "", "", amyt.a(this.jdField_a_of_type_Amyt), amyt.a(this.jdField_a_of_type_Amyt), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyu
 * JD-Core Version:    0.7.0.1
 */