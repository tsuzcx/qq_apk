import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anod
  implements View.OnClickListener
{
  anod(anob paramanob, annm paramannm, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((anob.a(this.jdField_a_of_type_Anob) != null) && (anob.a(this.jdField_a_of_type_Anob).app != null) && (anob.a(this.jdField_a_of_type_Anob) != null)) {
      anob.a(this.jdField_a_of_type_Anob).b(anob.a(this.jdField_a_of_type_Anob), this.jdField_a_of_type_Annm);
    }
    this.jdField_a_of_type_Anob.a();
    anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "action_flame_clicksend");
    anme.a(102, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anod
 * JD-Core Version:    0.7.0.1
 */