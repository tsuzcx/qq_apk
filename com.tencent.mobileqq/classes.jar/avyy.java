import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import mqq.app.AppRuntime.Status;

class avyy
  extends ClickableSpan
{
  avyy(avyo paramavyo, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(avyo.a(this.jdField_a_of_type_Avyo), paramView, AccountOnlineStateActivity.class);
    if ((avyo.a(this.jdField_a_of_type_Avyo) != null) && (avyo.a(this.jdField_a_of_type_Avyo).isShowing()))
    {
      avyo.a(this.jdField_a_of_type_Avyo).dismiss();
      avyo.a(this.jdField_a_of_type_Avyo, null);
    }
    azmj.b(avyo.a(this.jdField_a_of_type_Avyo), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyy
 * JD-Core Version:    0.7.0.1
 */