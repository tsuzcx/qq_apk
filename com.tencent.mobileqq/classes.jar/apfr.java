import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.3;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.4;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.5;
import java.util.List;

public class apfr
  extends awkc<awog, awwp>
{
  public apfr(FileSelectorSearchFragment paramFileSelectorSearchFragment) {}
  
  protected awrb<awog, awwp> a(int paramInt)
  {
    apfx localapfx = new apfx();
    localapfx.a(new apfs(this));
    return localapfx;
  }
  
  protected awwq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apga(paramViewGroup);
  }
  
  public void a(List<awog> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
  }
  
  public void a(List<awog> paramList, boolean paramBoolean)
  {
    super.a(paramList, paramBoolean);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.4(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfr
 * JD-Core Version:    0.7.0.1
 */