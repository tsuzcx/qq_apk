import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bfql
  implements DialogInterface.OnClickListener
{
  public bfql(PublishHomeWorkFragment paramPublishHomeWorkFragment, FormSwitchItem paramFormSwitchItem, CompoundButton paramCompoundButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.e = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.d = false;
    this.jdField_a_of_type_AndroidWidgetCompoundButton.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfql
 * JD-Core Version:    0.7.0.1
 */