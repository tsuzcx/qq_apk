import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awoa
  implements View.OnClickListener
{
  awoa(awnx paramawnx, awit paramawit, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Awit.a();
    Object localObject = this.jdField_a_of_type_Awit.a();
    awiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.a(3, i, (String)localObject);
    localObject = new awit(i, (String)localObject);
    awiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((awit)localObject, false);
    bdla.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoa
 * JD-Core Version:    0.7.0.1
 */