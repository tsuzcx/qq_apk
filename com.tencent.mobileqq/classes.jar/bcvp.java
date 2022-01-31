import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;

public class bcvp
  implements View.OnClickListener
{
  public bcvp(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.a.this$0.b();
    paramView = this.a.a.this$0;
    paramView.jdField_a_of_type_Int += 1;
    if (this.a.a.this$0.jdField_a_of_type_Boolean)
    {
      this.a.a.this$0.jdField_a_of_type_Boolean = false;
      this.a.a.this$0.a(this.a.a.a, this.a.a.a.frienduin, this.a.a.a.interactId, this.a.a.a.animationPackageId, this.a.a.this$0.jdField_a_of_type_Int, false);
    }
    if (this.a.a.this$0.jdField_a_of_type_Int % 5 == 0) {
      this.a.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.a(this.a.a.a.animationPackageId + "");
    }
    azqs.b(null, "dc00899", "Grp_flower", "", "inter_gift", "clk_ball", 0, 0, this.a.a.a.frienduin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvp
 * JD-Core Version:    0.7.0.1
 */