import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class asio
  extends ClickableSpan
{
  asio(asim paramasim, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    asim.a(this.jdField_a_of_type_Asim, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_Asim.a.getApp().getResources().getColor(2131166862));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asio
 * JD-Core Version:    0.7.0.1
 */