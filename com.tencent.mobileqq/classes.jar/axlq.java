import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class axlq
  implements ActionMode.Callback
{
  public axlq(OCRResultActivity paramOCRResultActivity, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131371981)
    {
      paramActionMode = OCRResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity, this.jdField_a_of_type_AndroidWidgetEditText);
      if (TextUtils.isEmpty(paramActionMode)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity, 1, amtj.a(2131706926), 0).a();
      }
    }
    else
    {
      return false;
    }
    OCRTextSearchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity, paramActionMode);
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity.overridePendingTransition(2130771992, 0);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131623939, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlq
 * JD-Core Version:    0.7.0.1
 */