import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class blgr
  implements View.OnSystemUiVisibilityChangeListener
{
  public blgr(XPanelContainer paramXPanelContainer) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (XPanelContainer.b != bool)
      {
        XPanelContainer.a(this.a, true);
        XPanelContainer.b = bool;
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "onSystemUiVisibilityChange..visibility =  " + paramInt + " context = " + this.a.getContext().getClass().getName());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgr
 * JD-Core Version:    0.7.0.1
 */