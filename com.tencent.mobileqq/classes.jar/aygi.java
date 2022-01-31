import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class aygi
  extends ClickableSpan
{
  public aygi(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity, 2002, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.t);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      awqx.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_add_topic", i, 0, "", "", "", "");
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aygi
 * JD-Core Version:    0.7.0.1
 */