import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.3;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.4;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.5;
import java.util.List;

public class aqyt
  extends ayfe<ayjl, ayru>
{
  public aqyt(FileSelectorSearchFragment paramFileSelectorSearchFragment) {}
  
  protected aymg<ayjl, ayru> a(int paramInt)
  {
    aqyz localaqyz = new aqyz();
    localaqyz.a(new aqyu(this));
    return localaqyz;
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    return new aqzc(paramViewGroup);
  }
  
  public void a(List<ayjl> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
  }
  
  public void a(List<ayjl> paramList, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyt
 * JD-Core Version:    0.7.0.1
 */