import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.List;

public class apfu
  extends awkc<awog, awwp>
{
  public apfu(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, apfw paramapfw)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramapfw.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected awrb<awog, awwp> a(int paramInt)
  {
    apfx localapfx = new apfx();
    localapfx.a(new apfv(this));
    return localapfx;
  }
  
  protected awwq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apga(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfu
 * JD-Core Version:    0.7.0.1
 */