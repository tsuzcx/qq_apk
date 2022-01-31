import android.widget.ImageButton;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class atwx
  implements PopupWindow.OnDismissListener
{
  public atwx(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onDismiss  endOfAnim: %s", new Object[] { Boolean.valueOf(this.a.d) }));
    }
    this.a.d = true;
    this.a.a.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwx
 * JD-Core Version:    0.7.0.1
 */