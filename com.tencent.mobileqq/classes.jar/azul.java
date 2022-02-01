import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

class azul
  extends ClickableSpan
{
  azul(azuj paramazuj, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    new azuo(azuj.a(this.jdField_a_of_type_Azuj).a).a(this.jdField_a_of_type_JavaLangString).a();
    bcst.b(azuj.a(this.jdField_a_of_type_Azuj).a(), "dc00898", "", "", "0X800A4BB", "0X800A4BB", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(bggq.a(azuj.a(this.jdField_a_of_type_Azuj).a, 14.0F));
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    if (!TextUtils.isEmpty(this.b)) {
      paramTextPaint.setColor(Color.parseColor(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      paramTextPaint.setTextSize(Float.valueOf(this.c).floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azul
 * JD-Core Version:    0.7.0.1
 */