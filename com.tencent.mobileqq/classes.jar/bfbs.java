import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.2;
import java.util.Iterator;
import java.util.List;

public class bfbs
  implements belx
{
  public bfbs(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onSoftKeyboardClosed()
  {
    betc.d("AppBrandPageContainer", "onSoftKeyboardClosed ");
    if ((AppBrandPageContainer.a(this.a) != null) && (AppBrandPageContainer.a(this.a).size() > 0))
    {
      Iterator localIterator = AppBrandPageContainer.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        belx localbelx = (belx)localIterator.next();
        if (localbelx != null) {
          localbelx.onSoftKeyboardClosed();
        }
      }
    }
    bejn.a().postDelayed(new AppBrandPageContainer.1.2(this), 50L);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    betc.d("AppBrandPageContainer", "onSoftKeyboardOpened " + paramInt);
    if (AppBrandPageContainer.a(this.a) != null) {}
    int i;
    for (Object localObject = AppBrandPageContainer.a(this.a).a();; localObject = null)
    {
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (bfgl.a((Context)localObject))
        {
          i = paramInt;
          if (bfgl.a((Activity)localObject)) {
            i = paramInt - bfgl.c((Context)localObject);
          }
        }
      }
      if ((AppBrandPageContainer.a(this.a) == null) || (AppBrandPageContainer.a(this.a).size() <= 0)) {
        break;
      }
      localObject = AppBrandPageContainer.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        belx localbelx = (belx)((Iterator)localObject).next();
        if (localbelx != null) {
          localbelx.onSoftKeyboardOpened(i);
        }
      }
    }
    bejn.a().postDelayed(new AppBrandPageContainer.1.1(this, i), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbs
 * JD-Core Version:    0.7.0.1
 */