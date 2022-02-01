import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayli
  implements View.OnClickListener
{
  public ayli(PromotionEntry paramPromotionEntry, aosj paramaosj) {}
  
  public void onClick(View paramView)
  {
    bcst.b(null, "CliOper", "", "", "0X8009C6B", "0X8009C6B", 0, 0, this.jdField_a_of_type_Aosj.a, "0", "0", "");
    PromotionEntry.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry).b(this.jdField_a_of_type_Aosj);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayli
 * JD-Core Version:    0.7.0.1
 */