import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.widget.AdapterView;

public class bccs
  implements bhuw
{
  public bccs(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.getCount())
    {
      paramAdapterView = this.a.jdField_a_of_type_Bccz.a(paramInt);
      this.a.a(paramInt, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccs
 * JD-Core Version:    0.7.0.1
 */