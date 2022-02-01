import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhjw
  implements View.OnClickListener
{
  public bhjw(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout;
    QQCustomMenuNoIconLayout localQQCustomMenuNoIconLayout = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout);
      QQCustomMenuNoIconLayout.a((QQCustomMenuNoIconLayout)localObject, localQQCustomMenuNoIconLayout.a(i), true);
      localQQCustomMenuNoIconLayout = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout;
      if (!this.jdField_a_of_type_Boolean) {
        break label78;
      }
    }
    label78:
    for (localObject = "0X800B3C1";; localObject = "0X800B3C3")
    {
      QQCustomMenuNoIconLayout.a(localQQCustomMenuNoIconLayout, (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = QQCustomMenuNoIconLayout.b(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjw
 * JD-Core Version:    0.7.0.1
 */