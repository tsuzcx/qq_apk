import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;

public class bfbq
  implements ViewTreeObserver.OnScrollChangedListener
{
  public bfbq(PageWebviewContainer paramPageWebviewContainer) {}
  
  public void onScrollChanged()
  {
    PageWebviewContainer.a(this.a).a().getView().scrollTo(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbq
 * JD-Core Version:    0.7.0.1
 */