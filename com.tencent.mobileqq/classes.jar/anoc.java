import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anoc
  implements View.OnClickListener
{
  anoc(anob paramanob, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    if (anob.a(this.jdField_a_of_type_Anob) != null) {
      anob.a(this.jdField_a_of_type_Anob).a(3, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    }
    for (;;)
    {
      this.jdField_a_of_type_Anob.a();
      anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "unlockeddownload");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ApolloNewActionFloatViewController", 1, "showKapuLockActionView mAppController null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoc
 * JD-Core Version:    0.7.0.1
 */