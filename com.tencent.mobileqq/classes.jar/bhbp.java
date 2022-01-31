import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Iterator;
import java.util.List;

public class bhbp
  implements View.OnClickListener
{
  public bhbp(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = NativeViewContainer.a(this.a).iterator();
    while (paramView.hasNext())
    {
      bhbq localbhbq = (bhbq)paramView.next();
      if (localbhbq != null) {
        localbhbq.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbp
 * JD-Core Version:    0.7.0.1
 */