import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class awxl
  extends ClickableSpan
{
  awxl(awxj paramawxj, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    awxj.a(this.jdField_a_of_type_Awxj, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_Awxj.a.getApp().getResources().getColor(2131167034));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxl
 * JD-Core Version:    0.7.0.1
 */