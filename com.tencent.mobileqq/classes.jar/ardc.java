import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.2;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.3;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.4;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.5;
import java.util.List;

public class ardc
  extends ayjn<aynu, aywd>
{
  public ardc(FileSelectorSearchFragment paramFileSelectorSearchFragment) {}
  
  protected ayqp<aynu, aywd> a(int paramInt)
  {
    ardi localardi = new ardi();
    localardi.a(new ardd(this));
    return localardi;
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ardl(paramViewGroup);
  }
  
  public void a(List<aynu> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
  }
  
  public void a(List<aynu> paramList, boolean paramBoolean)
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
 * Qualified Name:     ardc
 * JD-Core Version:    0.7.0.1
 */