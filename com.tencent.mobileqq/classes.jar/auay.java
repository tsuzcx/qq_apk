import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;

public class auay
  implements ActionMode.Callback
{
  public auay(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131371005)
    {
      paramActionMode = auad.a(this.jdField_a_of_type_AndroidWidgetEditText);
      if (TextUtils.isEmpty(paramActionMode)) {
        bcql.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), 1, ajya.a(2131707828), 0).a();
      }
    }
    else
    {
      return false;
    }
    OCRTextSearchActivity.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), paramActionMode);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).overridePendingTransition(2130771992, 0);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131623940, paramMenu);
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
 * Qualified Name:     auay
 * JD-Core Version:    0.7.0.1
 */