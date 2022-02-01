import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aqww
  extends ClickableSpan
{
  aqww(aqwv paramaqwv, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    bgrl.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (Activity)this.jdField_a_of_type_AndroidContentContext);
    bcst.b(null, "dc00898", "", "", aqwv.a(this.jdField_a_of_type_Aqwv), aqwv.a(this.jdField_a_of_type_Aqwv), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqww
 * JD-Core Version:    0.7.0.1
 */