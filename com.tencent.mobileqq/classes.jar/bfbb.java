import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.2;
import java.util.Iterator;
import java.util.List;

public class bfbb
  implements belg
{
  public bfbb(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onSoftKeyboardClosed()
  {
    besl.d("AppBrandPageContainer", "onSoftKeyboardClosed ");
    if ((AppBrandPageContainer.a(this.a) != null) && (AppBrandPageContainer.a(this.a).size() > 0))
    {
      Iterator localIterator = AppBrandPageContainer.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        belg localbelg = (belg)localIterator.next();
        if (localbelg != null) {
          localbelg.onSoftKeyboardClosed();
        }
      }
    }
    beiw.a().postDelayed(new AppBrandPageContainer.1.2(this), 50L);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    besl.d("AppBrandPageContainer", "onSoftKeyboardOpened " + paramInt);
    if (AppBrandPageContainer.a(this.a) != null) {}
    int i;
    for (Object localObject = AppBrandPageContainer.a(this.a).a();; localObject = null)
    {
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (bffu.a((Context)localObject))
        {
          i = paramInt;
          if (bffu.a((Activity)localObject)) {
            i = paramInt - bffu.c((Context)localObject);
          }
        }
      }
      if ((AppBrandPageContainer.a(this.a) == null) || (AppBrandPageContainer.a(this.a).size() <= 0)) {
        break;
      }
      localObject = AppBrandPageContainer.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        belg localbelg = (belg)((Iterator)localObject).next();
        if (localbelg != null) {
          localbelg.onSoftKeyboardOpened(i);
        }
      }
    }
    beiw.a().postDelayed(new AppBrandPageContainer.1.1(this, i), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbb
 * JD-Core Version:    0.7.0.1
 */