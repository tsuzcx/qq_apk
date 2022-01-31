import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class asim
  extends ClickableSpan
{
  asim(asik paramasik, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    asik.a(this.jdField_a_of_type_Asik, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_Asik.a.getApp().getResources().getColor(2131166862));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asim
 * JD-Core Version:    0.7.0.1
 */