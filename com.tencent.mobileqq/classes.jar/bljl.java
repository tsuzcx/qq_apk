import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;
import com.tencent.widget.AdapterView;

public class bljl
  extends DataSetObserver
{
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  
  public bljl(AdapterView paramAdapterView) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsParcelable = null;
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mDataChanged = true;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mOldItemCount = this.jdField_a_of_type_ComTencentWidgetAdapterView.mItemCount;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mItemCount = this.jdField_a_of_type_ComTencentWidgetAdapterView.getAdapter().getCount();
    if ((this.jdField_a_of_type_ComTencentWidgetAdapterView.getAdapter().hasStableIds()) && (this.jdField_a_of_type_AndroidOsParcelable != null) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.mOldItemCount == 0) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.mItemCount > 0))
    {
      AdapterView.access$000(this.jdField_a_of_type_ComTencentWidgetAdapterView, this.jdField_a_of_type_AndroidOsParcelable);
      this.jdField_a_of_type_AndroidOsParcelable = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAdapterView.checkFocus();
      this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
      return;
      this.jdField_a_of_type_ComTencentWidgetAdapterView.rememberSyncState();
    }
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mDataChanged = true;
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView.getAdapter().hasStableIds()) {
      this.jdField_a_of_type_AndroidOsParcelable = AdapterView.access$100(this.jdField_a_of_type_ComTencentWidgetAdapterView);
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mOldItemCount = this.jdField_a_of_type_ComTencentWidgetAdapterView.mItemCount;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mItemCount = 0;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mSelectedPosition = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mSelectedRowId = -9223372036854775808L;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mNextSelectedPosition = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mNextSelectedRowId = -9223372036854775808L;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.mNeedSync = false;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.checkFocus();
    this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bljl
 * JD-Core Version:    0.7.0.1
 */