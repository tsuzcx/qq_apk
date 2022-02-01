import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrq
  implements View.OnClickListener
{
  public anrq(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel) != null)
    {
      anra localanra = new anra();
      localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a, localanra);
      amsx.a(124, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrq
 * JD-Core Version:    0.7.0.1
 */