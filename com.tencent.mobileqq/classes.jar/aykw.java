import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class aykw
  extends ayjp<aynx, ayxt>
{
  public aykw(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, bdbb parambdbb, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, parambdbb, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected ayqp a(int paramInt)
  {
    return new ayrm(MessageSearchDetailFragment.a(this.a));
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ayxt(paramViewGroup, 2131562610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykw
 * JD-Core Version:    0.7.0.1
 */