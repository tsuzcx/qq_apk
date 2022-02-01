import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import java.util.HashMap;

public class axvr
  implements DialogInterface.OnDismissListener
{
  public axvr(StoryPlayController paramStoryPlayController, axzk paramaxzk, HashMap paramHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Axzk.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.b();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axzk.jdField_a_of_type_Int)) != null) {
        ((axzv)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axzk.jdField_a_of_type_Int))).h();
      }
    }
    StoryPlayController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvr
 * JD-Core Version:    0.7.0.1
 */