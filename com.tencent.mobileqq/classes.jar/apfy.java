import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class apfy
  extends awke<awoi, awwr>
{
  public apfy(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, apga paramapga)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramapga.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected awrd<awoi, awwr> a(int paramInt)
  {
    apgb localapgb = new apgb();
    localapgb.a(new apfz(this));
    return localapgb;
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apge(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfy
 * JD-Core Version:    0.7.0.1
 */