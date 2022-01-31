import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import mqq.app.AppRuntime.Status;

class auht
  extends ClickableSpan
{
  auht(auhi paramauhi, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(auhi.a(this.jdField_a_of_type_Auhi), paramView, AccountOnlineStateActivity.class);
    if ((auhi.a(this.jdField_a_of_type_Auhi) != null) && (auhi.a(this.jdField_a_of_type_Auhi).isShowing()))
    {
      auhi.a(this.jdField_a_of_type_Auhi).dismiss();
      auhi.a(this.jdField_a_of_type_Auhi, null);
    }
    axqw.b(auhi.a(this.jdField_a_of_type_Auhi), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auht
 * JD-Core Version:    0.7.0.1
 */