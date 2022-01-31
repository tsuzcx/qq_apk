import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;

public class bage
  implements View.OnClickListener
{
  public bage(VisitorTroopCardFragment paramVisitorTroopCardFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    VisitorTroopCardFragment.c(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bage
 * JD-Core Version:    0.7.0.1
 */