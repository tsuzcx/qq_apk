import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bati
  implements View.OnClickListener
{
  bati(batg parambatg, bhgl parambhgl) {}
  
  public void onClick(View paramView)
  {
    ((anaq)bate.a(this.jdField_a_of_type_Batg.jdField_a_of_type_Bate).getManager(299)).a();
    this.jdField_a_of_type_Bhgl.dismiss();
    bate.a(this.jdField_a_of_type_Batg.jdField_a_of_type_Bate);
    bbda.a(this.jdField_a_of_type_Batg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(bbda.a(this.jdField_a_of_type_Batg.jdField_a_of_type_Bate.b)).ver7("{experiment_id:" + bbda.b + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bati
 * JD-Core Version:    0.7.0.1
 */