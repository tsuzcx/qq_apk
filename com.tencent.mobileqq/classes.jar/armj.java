import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class armj
  extends ClickableSpan
{
  armj(armh paramarmh, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    armh.a(this.jdField_a_of_type_Armh, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_Armh.a.getApp().getResources().getColor(2131101268));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armj
 * JD-Core Version:    0.7.0.1
 */