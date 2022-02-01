import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amrh
  implements View.OnClickListener
{
  amrh(amre paramamre) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof amrn)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (amrn)localObject;
      if ((((amrn)localObject).a != null) && (((amrn)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
        this.a.jdField_a_of_type_Amrj.a(((amrn)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, ((amrn)localObject).a.jdField_a_of_type_Int);
      }
      if ((((amrn)localObject).a != null) && (((amrn)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
        this.a.jdField_a_of_type_Amrj.a(((amrn)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      }
      new bdlq(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrh
 * JD-Core Version:    0.7.0.1
 */