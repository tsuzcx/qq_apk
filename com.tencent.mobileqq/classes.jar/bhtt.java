import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.widget.AbsListView;

@SuppressLint({"NewApi"})
public class bhtt
  implements bhts
{
  private bhts jdField_a_of_type_Bhts;
  
  public bhtt(AbsListView paramAbsListView) {}
  
  public void a(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhts.a(paramActionMode, paramInt, paramLong, paramBoolean);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.getCheckedItemCount() == 0) {
      paramActionMode.finish();
    }
  }
  
  public void a(bhts parambhts)
  {
    this.jdField_a_of_type_Bhts = parambhts;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.jdField_a_of_type_Bhts.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bhts.onCreateActionMode(paramActionMode, paramMenu))
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setLongClickable(false);
      bool = true;
    }
    return bool;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.jdField_a_of_type_Bhts.onDestroyActionMode(paramActionMode);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.mChoiceActionMode = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.clearChoices();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.mDataChanged = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.rememberSyncState();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.requestLayout();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setLongClickable(true);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.jdField_a_of_type_Bhts.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhtt
 * JD-Core Version:    0.7.0.1
 */