import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class auua
  implements View.OnClickListener
{
  auua(QQAppInterface paramQQAppInterface, String paramString, auub paramauub, arqd paramarqd) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Auub.a(this.jdField_a_of_type_Arqd.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auua
 * JD-Core Version:    0.7.0.1
 */