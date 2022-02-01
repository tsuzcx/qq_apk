import android.view.ViewGroup;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment;
import com.tencent.widget.ListView;
import java.util.List;

public class bbkj
  extends bbki<bbkm, bbww>
{
  public bbkj(FTSEntitySearchDetailFragment paramFTSEntitySearchDetailFragment, ListView paramListView, aobu paramaobu, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramaobu, paramList, paramString, paramFTSEntitySearchDetailActivity);
  }
  
  protected bbps a(int paramInt)
  {
    return new bbpp(FTSEntitySearchDetailFragment.a(this.a));
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bbvc(paramViewGroup, 2131562844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkj
 * JD-Core Version:    0.7.0.1
 */