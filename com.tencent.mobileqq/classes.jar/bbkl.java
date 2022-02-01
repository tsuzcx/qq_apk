import android.view.ViewGroup;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.widget.ListView;

public class bbkl
  extends bbip<bbmy, bbvg>
{
  public bbkl(FTSEntitySearchFragment paramFTSEntitySearchFragment, ListView paramListView, aobu paramaobu)
  {
    super(paramListView, paramaobu);
  }
  
  protected bbps<bbmy, bbvg> a(int paramInt)
  {
    return new bbpp(FTSEntitySearchFragment.a(this.a));
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bbvc(paramViewGroup, 2131562846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkl
 * JD-Core Version:    0.7.0.1
 */