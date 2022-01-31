import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class asfy
  extends PopupWindow
{
  private PopupWindow.OnDismissListener a;
  
  public asfy(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a()
  {
    super.dismiss();
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.a = paramOnDismissListener;
  }
  
  public void dismiss()
  {
    if (this.a != null)
    {
      this.a.onDismiss();
      return;
    }
    super.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfy
 * JD-Core Version:    0.7.0.1
 */