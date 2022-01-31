import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.2;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.Iterator;
import java.util.List;

public class bhbe
  implements bgln
{
  public bhbe(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onSoftKeyboardClosed()
  {
    QMLog.e("minisdk-start-AppBrandPageContainer", "onSoftKeyboardClosed ");
    if ((AppBrandPageContainer.a(this.a) != null) && (AppBrandPageContainer.a(this.a).size() > 0))
    {
      Iterator localIterator = AppBrandPageContainer.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        bgln localbgln = (bgln)localIterator.next();
        if (localbgln != null) {
          localbgln.onSoftKeyboardClosed();
        }
      }
    }
    ThreadManager.a().postDelayed(new AppBrandPageContainer.1.2(this), 50L);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    QMLog.e("minisdk-start-AppBrandPageContainer", "onSoftKeyboardOpened " + paramInt);
    if (AppBrandPageContainer.a(this.a) != null) {}
    int i;
    for (Object localObject = AppBrandPageContainer.a(this.a).a();; localObject = null)
    {
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (DisplayUtil.hasNavBar((Context)localObject))
        {
          i = paramInt;
          if (DisplayUtil.isNavigationBarExist((Activity)localObject)) {
            i = paramInt - DisplayUtil.getNavigationBarHeight((Context)localObject);
          }
        }
      }
      if ((AppBrandPageContainer.a(this.a) == null) || (AppBrandPageContainer.a(this.a).size() <= 0)) {
        break;
      }
      localObject = AppBrandPageContainer.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bgln localbgln = (bgln)((Iterator)localObject).next();
        if (localbgln != null) {
          localbgln.onSoftKeyboardOpened(i);
        }
      }
    }
    ThreadManager.a().postDelayed(new AppBrandPageContainer.1.1(this, i), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbe
 * JD-Core Version:    0.7.0.1
 */