import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amkc
  implements View.OnClickListener
{
  amkc(amjz paramamjz) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof amki)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (amki)localObject;
      if ((((amki)localObject).a != null) && (((amki)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
        this.a.jdField_a_of_type_Amke.a(((amki)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, ((amki)localObject).a.jdField_a_of_type_Int);
      }
      if ((((amki)localObject).a != null) && (((amki)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
        this.a.jdField_a_of_type_Amke.a(((amki)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      }
      new bdlf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkc
 * JD-Core Version:    0.7.0.1
 */