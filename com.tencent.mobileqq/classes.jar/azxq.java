import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;

public class azxq
  implements View.OnFocusChangeListener
{
  public azxq(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.jdField_a_of_type_Boolean = bool;
      if (paramBoolean)
      {
        this.a.l = true;
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxq
 * JD-Core Version:    0.7.0.1
 */