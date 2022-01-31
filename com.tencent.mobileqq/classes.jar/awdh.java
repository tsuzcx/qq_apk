import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import mqq.app.AppRuntime.Status;

class awdh
  extends ClickableSpan
{
  awdh(awcx paramawcx, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(awcx.a(this.jdField_a_of_type_Awcx), paramView, AccountOnlineStateActivity.class);
    if ((awcx.a(this.jdField_a_of_type_Awcx) != null) && (awcx.a(this.jdField_a_of_type_Awcx).isShowing()))
    {
      awcx.a(this.jdField_a_of_type_Awcx).dismiss();
      awcx.a(this.jdField_a_of_type_Awcx, null);
    }
    azqs.b(awcx.a(this.jdField_a_of_type_Awcx), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdh
 * JD-Core Version:    0.7.0.1
 */