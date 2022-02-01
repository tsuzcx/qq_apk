import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;

class baaj
  implements View.OnClickListener
{
  baaj(baai parambaai, azrb paramazrb, Card paramCard, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    localHashMap.put("key_jump_from", "5");
    vvh.a(BaseApplication.getContext(), "openmainpage", localHashMap);
    if (!TextUtils.isEmpty(baai.a(this.jdField_a_of_type_Baai)))
    {
      QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 4);
      baai.a(this.jdField_a_of_type_Baai, null);
      if ((baai.a() != null) && (baai.a().size() > 0)) {
        baai.a().remove(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      }
    }
    for (;;)
    {
      azyh.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baaj
 * JD-Core Version:    0.7.0.1
 */