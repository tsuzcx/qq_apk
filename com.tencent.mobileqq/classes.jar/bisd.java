import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bisd
  implements View.OnClickListener
{
  public bisd(PublicMenuBar paramPublicMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PublicMenuBar.a(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar) != null) {
      PublicMenuBar.b(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bisd
 * JD-Core Version:    0.7.0.1
 */