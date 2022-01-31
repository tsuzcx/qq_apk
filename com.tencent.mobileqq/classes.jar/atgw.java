import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import java.util.HashMap;

public class atgw
  implements DialogInterface.OnDismissListener
{
  public atgw(StoryPlayController paramStoryPlayController, atkn paramatkn, HashMap paramHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Atkn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.b();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Atkn.jdField_a_of_type_Int)) != null) {
        ((atky)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Atkn.jdField_a_of_type_Int))).h();
      }
    }
    StoryPlayController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgw
 * JD-Core Version:    0.7.0.1
 */