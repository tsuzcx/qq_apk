import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbzx
  implements View.OnClickListener
{
  bbzx(bbzv parambbzv, bird parambird) {}
  
  public void onClick(View paramView)
  {
    ((aodf)bbzt.a(this.jdField_a_of_type_Bbzv.jdField_a_of_type_Bbzt).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a();
    this.jdField_a_of_type_Bird.dismiss();
    bbzt.a(this.jdField_a_of_type_Bbzv.jdField_a_of_type_Bbzt);
    bcjs.a(this.jdField_a_of_type_Bbzv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(bcjs.a(this.jdField_a_of_type_Bbzv.jdField_a_of_type_Bbzt.b)).ver7("{experiment_id:" + bcjs.b + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzx
 * JD-Core Version:    0.7.0.1
 */