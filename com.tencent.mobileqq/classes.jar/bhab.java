import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhab
  implements View.OnClickListener
{
  public bhab(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.a.this$0.b();
    bhaa localbhaa = this.a.a.this$0;
    localbhaa.jdField_a_of_type_Int += 1;
    if (this.a.a.this$0.jdField_a_of_type_Boolean)
    {
      this.a.a.this$0.jdField_a_of_type_Boolean = false;
      this.a.a.this$0.a(this.a.a.a, this.a.a.a.frienduin, this.a.a.a.interactId, this.a.a.a.animationPackageId, this.a.a.this$0.jdField_a_of_type_Int, false);
    }
    if (this.a.a.this$0.jdField_a_of_type_Int % 5 == 0) {
      this.a.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.a(this.a.a.a.animationPackageId + "");
    }
    bdll.b(null, "dc00899", "Grp_flower", "", "inter_gift", "clk_ball", 0, 0, this.a.a.a.frienduin, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhab
 * JD-Core Version:    0.7.0.1
 */