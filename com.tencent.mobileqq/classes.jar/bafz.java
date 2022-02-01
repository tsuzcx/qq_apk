import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bafz
  implements View.OnClickListener
{
  bafz(bafx parambafx, azxr paramazxr, Card paramCard, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    localQCircleInitBean.setLaunchFrom("5");
    uyx.b(paramView.getContext(), localQCircleInitBean);
    vtq.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 2);
    baew.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azxr);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafz
 * JD-Core Version:    0.7.0.1
 */