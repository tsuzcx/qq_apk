import android.app.Activity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class amls
  implements View.OnFocusChangeListener
{
  public amls(XPanelContainer paramXPanelContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && ((this.a.getContext() instanceof Activity))) {
      QLog.d("XPanelContainer", 2, new Object[] { "input focus changed, hasFocus=", Boolean.valueOf(paramBoolean), ", current focus=", ((Activity)this.a.getContext()).getCurrentFocus() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amls
 * JD-Core Version:    0.7.0.1
 */