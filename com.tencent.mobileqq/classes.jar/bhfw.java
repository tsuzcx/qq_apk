import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Iterator;
import java.util.List;

public class bhfw
  implements View.OnClickListener
{
  public bhfw(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = NativeViewContainer.a(this.a).iterator();
    while (paramView.hasNext())
    {
      bhfx localbhfx = (bhfx)paramView.next();
      if (localbhfx != null) {
        localbhfx.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfw
 * JD-Core Version:    0.7.0.1
 */