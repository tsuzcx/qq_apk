import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aoqb
  extends ClickableSpan
{
  aoqb(aoqa paramaoqa, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    bdia.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (Activity)this.jdField_a_of_type_AndroidContentContext);
    azmj.b(null, "dc00898", "", "", aoqa.a(this.jdField_a_of_type_Aoqa), aoqa.a(this.jdField_a_of_type_Aoqa), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqb
 * JD-Core Version:    0.7.0.1
 */