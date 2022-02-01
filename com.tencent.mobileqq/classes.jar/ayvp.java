import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;

class ayvp
  implements View.OnClickListener
{
  ayvp(ayvm paramayvm, aymg paramaymg, Card paramCard, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    localHashMap.put("key_jump_from", "5");
    vgn.a(BaseApplication.getContext(), "openmainpage", localHashMap);
    if (!TextUtils.isEmpty(ayvm.a(this.jdField_a_of_type_Ayvm)))
    {
      QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 4);
      ayvm.a(this.jdField_a_of_type_Ayvm, null);
      ayvm.a(this.jdField_a_of_type_Ayvm, ((aymg)ayvm.e(this.jdField_a_of_type_Ayvm)).jdField_a_of_type_ComTencentMobileqqDataCard);
    }
    for (;;)
    {
      aytl.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aymg);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvp
 * JD-Core Version:    0.7.0.1
 */