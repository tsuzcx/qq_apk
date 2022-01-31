import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Iterator;
import java.util.List;

public class bfcc
  implements View.OnClickListener
{
  public bfcc(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = NativeViewContainer.a(this.a).iterator();
    while (paramView.hasNext())
    {
      bfcd localbfcd = (bfcd)paramView.next();
      if (localbfcd != null) {
        localbfcd.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcc
 * JD-Core Version:    0.7.0.1
 */