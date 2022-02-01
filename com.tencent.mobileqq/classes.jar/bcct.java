import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class bcct
  extends bcbk<bcfu, bcpp>
{
  public bcct(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, aoof paramaoof, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramaoof, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected bcil a(int paramInt)
  {
    return new bcji(MessageSearchDetailFragment.a(this.a));
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bcpp(paramViewGroup, 2131562882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcct
 * JD-Core Version:    0.7.0.1
 */