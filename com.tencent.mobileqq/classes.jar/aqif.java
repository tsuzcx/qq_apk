import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aqif
  extends ClickableSpan
{
  aqif(aqid paramaqid, String paramString) {}
  
  public void onClick(View paramView)
  {
    bfyi.a(aqid.a(this.jdField_a_of_type_Aqid), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    aqid.a("0X800AE6D", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqif
 * JD-Core Version:    0.7.0.1
 */