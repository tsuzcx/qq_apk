import android.widget.ImageButton;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class axbi
  implements PopupWindow.OnDismissListener
{
  public axbi(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onDismiss  endOfAnim: %s", new Object[] { Boolean.valueOf(this.a.d) }));
    }
    this.a.d = true;
    this.a.a.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbi
 * JD-Core Version:    0.7.0.1
 */