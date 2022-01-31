import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.3;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.4;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.5;
import java.util.List;

public class apfv
  extends awke<awoi, awwr>
{
  public apfv(FileSelectorSearchFragment paramFileSelectorSearchFragment) {}
  
  protected awrd<awoi, awwr> a(int paramInt)
  {
    apgb localapgb = new apgb();
    localapgb.a(new apfw(this));
    return localapgb;
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    return new apge(paramViewGroup);
  }
  
  public void a(List<awoi> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
  }
  
  public void a(List<awoi> paramList, boolean paramBoolean)
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
 * Qualified Name:     apfv
 * JD-Core Version:    0.7.0.1
 */