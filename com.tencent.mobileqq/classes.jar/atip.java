import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class atip
  extends bbio<bbmy, bbvg>
{
  public atip(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, atir paramatir)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramatir.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected bbps<bbmy, bbvg> a(int paramInt)
  {
    atis localatis = new atis();
    localatis.a(new atiq(this));
    return localatis;
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ativ(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atip
 * JD-Core Version:    0.7.0.1
 */