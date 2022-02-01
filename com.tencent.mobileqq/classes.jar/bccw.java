import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.widget.ListView;

public class bccw
  extends bcbd<bcfj, bcnt>
{
  public bccw(FTSEntitySearchFragment paramFTSEntitySearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected bcif<bcfj, bcnt> a(int paramInt)
  {
    return new bcic(FTSEntitySearchFragment.a(this.a));
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bcnp(paramViewGroup, 2131562830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccw
 * JD-Core Version:    0.7.0.1
 */