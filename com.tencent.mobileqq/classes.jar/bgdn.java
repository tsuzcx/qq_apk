import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgdn
  implements View.OnClickListener
{
  public bgdn(VisitorTroopCardFragment paramVisitorTroopCardFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    VisitorTroopCardFragment.g(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdn
 * JD-Core Version:    0.7.0.1
 */