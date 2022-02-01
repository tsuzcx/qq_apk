import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

final class bmlg
  implements View.OnClickListener
{
  bmlg(MqqHandler paramMqqHandler, QQAppInterface paramQQAppInterface, bbbu parambbbu) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
    bmlf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 122, this.jdField_a_of_type_Bbbu.a, this.jdField_a_of_type_Bbbu.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlg
 * JD-Core Version:    0.7.0.1
 */