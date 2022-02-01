import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class bccl
  extends bcbe<bcfm, bcpj>
{
  public bccl(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected bcif a(int paramInt)
  {
    return new bcjc(MessageSearchDetailFragment.a(this.a));
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bcpj(paramViewGroup, 2131562832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccl
 * JD-Core Version:    0.7.0.1
 */