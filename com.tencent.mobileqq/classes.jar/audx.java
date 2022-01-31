import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class audx
  extends ClickableSpan
{
  audx(audv paramaudv, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    audv.a(this.jdField_a_of_type_Audv, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_Audv.a.getApp().getResources().getColor(2131166911));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audx
 * JD-Core Version:    0.7.0.1
 */