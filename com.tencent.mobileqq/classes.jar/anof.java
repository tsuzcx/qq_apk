import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anof
  implements View.OnClickListener
{
  anof(anob paramanob, ApolloActionData paramApolloActionData, Bundle paramBundle, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    annl localannl = new annl();
    localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
    localannl.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("pkgId");
    if (anob.a(this.jdField_a_of_type_Anob) != null) {
      anob.a(this.jdField_a_of_type_Anob).a(anob.a(this.jdField_a_of_type_Anob), localannl);
    }
    this.jdField_a_of_type_Anob.a();
    anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "action_flame_clickgain");
    anme.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */