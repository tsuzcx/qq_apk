import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class atqz
  extends bcbc<bcfj, bcnt>
{
  public atqz(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, atrb paramatrb)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramatrb.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected bcif<bcfj, bcnt> a(int paramInt)
  {
    atrc localatrc = new atrc();
    localatrc.a(new atra(this));
    return localatrc;
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    return new atrf(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqz
 * JD-Core Version:    0.7.0.1
 */