import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aznn
  implements View.OnClickListener
{
  aznn(aznl paramaznl, azfe paramazfe, Card paramCard, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_jump_from", "5");
    uxo.a(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin, localIntent);
    vrf.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1, 2);
    azmk.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azfe);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznn
 * JD-Core Version:    0.7.0.1
 */