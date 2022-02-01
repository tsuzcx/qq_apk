import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amfn
  implements View.OnClickListener
{
  amfn(amfk paramamfk) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof amft)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (amft)localObject;
      if ((((amft)localObject).a != null) && (((amft)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
        this.a.jdField_a_of_type_Amfp.a(((amft)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, ((amft)localObject).a.jdField_a_of_type_Int);
      }
      if ((((amft)localObject).a != null) && (((amft)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
        this.a.jdField_a_of_type_Amfp.a(((amft)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      }
      new bcsy(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfn
 * JD-Core Version:    0.7.0.1
 */