import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.List;

public class bccu
  extends bcct<bccx, bcpj>
{
  public bccu(FTSEntitySearchDetailFragment paramFTSEntitySearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramFaceDecoder, paramList, paramString, paramFTSEntitySearchDetailActivity);
  }
  
  protected bcif a(int paramInt)
  {
    return new bcic(FTSEntitySearchDetailFragment.a(this.a));
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bcnp(paramViewGroup, 2131562828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccu
 * JD-Core Version:    0.7.0.1
 */