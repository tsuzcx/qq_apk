import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcae
  implements View.OnClickListener
{
  bcae(bcac parambcac, bjak parambjak) {}
  
  public void onClick(View paramView)
  {
    ((aohb)bcaa.a(this.jdField_a_of_type_Bcac.jdField_a_of_type_Bcaa).getManager(299)).a();
    this.jdField_a_of_type_Bjak.dismiss();
    bcaa.a(this.jdField_a_of_type_Bcac.jdField_a_of_type_Bcaa);
    bcjy.a(this.jdField_a_of_type_Bcac.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(bcjy.a(this.jdField_a_of_type_Bcac.jdField_a_of_type_Bcaa.b)).ver7("{experiment_id:" + bcjy.b + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcae
 * JD-Core Version:    0.7.0.1
 */