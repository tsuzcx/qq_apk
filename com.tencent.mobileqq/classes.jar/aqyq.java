import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aqyq
  extends ClickableSpan
{
  aqyq(aqyo paramaqyo, String paramString) {}
  
  public void onClick(View paramView)
  {
    bgrl.a(aqyo.a(this.jdField_a_of_type_Aqyo), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    aqyo.a("0X800AE6D", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyq
 * JD-Core Version:    0.7.0.1
 */