import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class aoah
  extends ClickableSpan
{
  Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public aoah(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramString1;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("PrivacyPolicyHelper", 1, "no system browser exp=", paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoah
 * JD-Core Version:    0.7.0.1
 */