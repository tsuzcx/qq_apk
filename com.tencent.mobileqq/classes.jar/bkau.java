import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

public class bkau
  extends PopupWindow
{
  private WeakReference<Context> a;
  
  public bkau(Context paramContext)
  {
    super(paramContext);
    this.a = new WeakReference(paramContext);
  }
  
  public void showAsDropDown(View paramView)
  {
    if (this.a.get() == null) {
      return;
    }
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (this.a.get() == null) {
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.get() == null) {
      return;
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bkau
 * JD-Core Version:    0.7.0.1
 */