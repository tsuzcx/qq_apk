import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;

public class ayys
  implements TextWatcher
{
  public ayys(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() == 0)
    {
      this.a.e();
      this.a.a(false);
      return;
    }
    this.a.jdField_a_of_type_Ayzb.a();
    this.a.jdField_a_of_type_Ayzb.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(false);
    this.a.b = 0;
    this.a.a(true);
    paramEditable = paramEditable.toString();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayys
 * JD-Core Version:    0.7.0.1
 */