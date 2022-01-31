import android.view.View;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.util.List;

public class bahc
  implements bfph
{
  public bahc(BulkSendMessageFragment paramBulkSendMessageFragment, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (String)this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaUtilList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramView);
    }
    this.jdField_a_of_type_Bfpc.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bahc
 * JD-Core Version:    0.7.0.1
 */