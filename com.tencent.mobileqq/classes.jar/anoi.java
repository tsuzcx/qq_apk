import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anoi
  implements View.OnClickListener
{
  anoi(anob paramanob, ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (anob.a(this.jdField_a_of_type_Anob) != null)
    {
      annl localannl = new annl();
      localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
      anob.a(this.jdField_a_of_type_Anob).c(anob.a(this.jdField_a_of_type_Anob), localannl);
    }
    if (this.jdField_a_of_type_Int == anob.a()) {
      anme.a(124, String.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int == anob.b()) {
      anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "unlockedpreview");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoi
 * JD-Core Version:    0.7.0.1
 */