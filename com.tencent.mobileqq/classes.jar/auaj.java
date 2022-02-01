import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class auaj
  extends bcbi<bcfr, bcnz>
{
  public auaj(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, aual paramaual)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramaual.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected bcil<bcfr, bcnz> a(int paramInt)
  {
    auam localauam = new auam();
    localauam.a(new auak(this));
    return localauam;
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new auap(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaj
 * JD-Core Version:    0.7.0.1
 */