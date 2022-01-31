import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class awln
  extends awkg<awol, awyh>
{
  public awln(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, baxy parambaxy, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambaxy, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected awrd a(int paramInt)
  {
    return new awsa(MessageSearchDetailFragment.a(this.a));
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    return new awyh(paramViewGroup, 2131562388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awln
 * JD-Core Version:    0.7.0.1
 */