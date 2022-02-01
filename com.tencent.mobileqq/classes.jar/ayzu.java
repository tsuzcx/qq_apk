import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppRuntime.Status;

class ayzu
  extends ClickableSpan
{
  ayzu(ayzg paramayzg, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(ayzg.a(this.jdField_a_of_type_Ayzg), paramView, AccountOnlineStateActivity.class, 234);
    if ((ayzg.a(this.jdField_a_of_type_Ayzg) != null) && (ayzg.a(this.jdField_a_of_type_Ayzg).isShowing()))
    {
      ayzg.a(this.jdField_a_of_type_Ayzg).dismiss();
      ayzg.a(this.jdField_a_of_type_Ayzg, null);
    }
    bdla.b(ayzg.a(this.jdField_a_of_type_Ayzg), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzu
 * JD-Core Version:    0.7.0.1
 */