import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

class avda
  extends ClickableSpan
{
  avda(avcy paramavcy, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    new avdd(avcy.a(this.jdField_a_of_type_Avcy).a).a(this.jdField_a_of_type_JavaLangString).a();
    axqy.b(avcy.a(this.jdField_a_of_type_Avcy).a(), "dc00898", "", "", "0X800A4BB", "0X800A4BB", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(baxn.a(avcy.a(this.jdField_a_of_type_Avcy).a, 14.0F));
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    if (!TextUtils.isEmpty(this.b)) {
      paramTextPaint.setColor(Color.parseColor(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      paramTextPaint.setTextSize(Float.valueOf(this.c).floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avda
 * JD-Core Version:    0.7.0.1
 */