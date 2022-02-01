import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfsk
  implements View.OnClickListener
{
  bfsk(bfse parambfse, Context paramContext, Dialog paramDialog, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bfse.b(this.jdField_a_of_type_Bfse, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppDialog);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C8", "0X800B0C8", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsk
 * JD-Core Version:    0.7.0.1
 */