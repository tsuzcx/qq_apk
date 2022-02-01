import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class bftl
  implements AdapterView.OnItemClickListener
{
  public bftl(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.getCount())
    {
      paramAdapterView = this.a.jdField_a_of_type_Bfts.a(paramInt);
      this.a.a(paramInt, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftl
 * JD-Core Version:    0.7.0.1
 */