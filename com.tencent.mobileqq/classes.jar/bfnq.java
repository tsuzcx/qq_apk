import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.FrameLayout;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.widget.PinnedFooterExpandableListView;

public class bfnq
  implements TextWatcher
{
  public bfnq(NewTroopContactView paramNewTroopContactView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setVisibility(0);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(paramEditable);
      }
      return;
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setVisibility(8);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnq
 * JD-Core Version:    0.7.0.1
 */