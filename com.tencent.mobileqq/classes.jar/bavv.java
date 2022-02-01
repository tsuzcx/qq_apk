import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class bavv
  extends bauo<bayw, bbir>
{
  public bavv(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected bbbn a(int paramInt)
  {
    return new bbck(MessageSearchDetailFragment.a(this.a));
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bbir(paramViewGroup, 2131562761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavv
 * JD-Core Version:    0.7.0.1
 */