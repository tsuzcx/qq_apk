import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class asmt
  extends baum<bayt, bbhb>
{
  public asmt(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, asmv paramasmv)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramasmv.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected bbbn<bayt, bbhb> a(int paramInt)
  {
    asmw localasmw = new asmw();
    localasmw.a(new asmu(this));
    return localasmw;
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new asmz(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmt
 * JD-Core Version:    0.7.0.1
 */