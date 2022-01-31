import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Iterator;
import java.util.List;

public class bdvd
  implements View.OnClickListener
{
  public bdvd(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = NativeViewContainer.a(this.a).iterator();
    while (paramView.hasNext())
    {
      bdve localbdve = (bdve)paramView.next();
      if (localbdve != null) {
        localbdve.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvd
 * JD-Core Version:    0.7.0.1
 */