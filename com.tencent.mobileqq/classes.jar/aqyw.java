import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class aqyw
  extends ayfe<ayjl, ayru>
{
  public aqyw(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, aqyy paramaqyy)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramaqyy.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected aymg<ayjl, ayru> a(int paramInt)
  {
    aqyz localaqyz = new aqyz();
    localaqyz.a(new aqyx(this));
    return localaqyz;
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aqzc(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyw
 * JD-Core Version:    0.7.0.1
 */