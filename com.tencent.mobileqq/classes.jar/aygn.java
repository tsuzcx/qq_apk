import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class aygn
  extends ayfg<ayjo, aytk>
{
  public aygn(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, bcws parambcws, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambcws, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected aymg a(int paramInt)
  {
    return new aynd(MessageSearchDetailFragment.a(this.a));
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aytk(paramViewGroup, 2131562592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygn
 * JD-Core Version:    0.7.0.1
 */