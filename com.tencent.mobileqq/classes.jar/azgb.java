import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import mqq.app.AppRuntime.Status;

class azgb
  extends ClickableSpan
{
  azgb(azfn paramazfn, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(azfn.a(this.jdField_a_of_type_Azfn), paramView, AccountOnlineStateActivity.class, 234);
    if ((azfn.a(this.jdField_a_of_type_Azfn) != null) && (azfn.a(this.jdField_a_of_type_Azfn).isShowing()))
    {
      azfn.a(this.jdField_a_of_type_Azfn).dismiss();
      azfn.a(this.jdField_a_of_type_Azfn, null);
    }
    bdll.b(azfn.a(this.jdField_a_of_type_Azfn), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgb
 * JD-Core Version:    0.7.0.1
 */