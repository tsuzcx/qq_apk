import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Iterator;
import java.util.List;

public class bfbl
  implements View.OnClickListener
{
  public bfbl(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = NativeViewContainer.a(this.a).iterator();
    while (paramView.hasNext())
    {
      bfbm localbfbm = (bfbm)paramView.next();
      if (localbfbm != null) {
        localbfbm.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbl
 * JD-Core Version:    0.7.0.1
 */