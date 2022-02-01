import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbhk
  implements View.OnClickListener
{
  bbhk(bbhi parambbhi, bhzm parambhzm) {}
  
  public void onClick(View paramView)
  {
    ((anur)bbhg.a(this.jdField_a_of_type_Bbhi.jdField_a_of_type_Bbhg).getManager(299)).a();
    this.jdField_a_of_type_Bhzm.dismiss();
    bbhg.a(this.jdField_a_of_type_Bbhi.jdField_a_of_type_Bbhg);
    bbrf.a(this.jdField_a_of_type_Bbhi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(bbrf.a(this.jdField_a_of_type_Bbhi.jdField_a_of_type_Bbhg.b)).ver7("{experiment_id:" + bbrf.b + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhk
 * JD-Core Version:    0.7.0.1
 */