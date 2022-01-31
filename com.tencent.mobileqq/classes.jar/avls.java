import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class avls
  extends avkl<avoq, avym>
{
  public avls(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, azwg paramazwg, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramazwg, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected avri a(int paramInt)
  {
    return new avsf(MessageSearchDetailFragment.a(this.a));
  }
  
  protected avwx a(int paramInt, ViewGroup paramViewGroup)
  {
    return new avym(paramViewGroup, 2131496789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avls
 * JD-Core Version:    0.7.0.1
 */