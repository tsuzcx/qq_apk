import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class ardf
  extends ayjn<aynu, aywd>
{
  public ardf(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, ardh paramardh)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramardh.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected ayqp<aynu, aywd> a(int paramInt)
  {
    ardi localardi = new ardi();
    localardi.a(new ardg(this));
    return localardi;
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ardl(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardf
 * JD-Core Version:    0.7.0.1
 */