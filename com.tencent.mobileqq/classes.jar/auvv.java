import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.qphone.base.util.QLog;

public class auvv
  implements View.OnClickListener
{
  public auvv(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      auts.b();
      if (!awlw.a(this.a.getContext())) {
        bbmy.a(this.a.getContext(), ajjy.a(2131642736), 0).a();
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (autt.a == 0)
        {
          bbmy.a(this.a.getContext(), ajjy.a(2131642742), 0).a();
          return;
        }
        if (autt.a != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
      return;
      if (autt.a == 2)
      {
        bool = autt.a(true);
        if (QLog.isColorLevel()) {
          QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck soLoaded=" + bool);
        }
        if (ProviderContainerView.a(this.a) != null) {
          ProviderContainerView.a(this.a).y();
        }
      }
      if (i != 103) {
        break label334;
      }
      auts.e();
      auts.b();
      if (!awlw.a(this.a.getContext()))
      {
        bbmy.a(this.a.getContext(), ajjy.a(2131642741), 0).a();
        return;
      }
      if (autt.a == 0)
      {
        bbmy.a(this.a.getContext(), ajjy.a(2131642740), 0).a();
        return;
      }
      if (autt.a != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
    return;
    if (autt.a == 2)
    {
      bool = autt.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).y();
      }
    }
    label334:
    if (i == 101) {
      auts.d();
    }
    if (i == 104)
    {
      awqx.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
      auts.c();
    }
    if (ProviderContainerView.a(this.a) != null) {
      ProviderContainerView.a(this.a).a();
    }
    ProviderContainerView.a(this.a, paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auvv
 * JD-Core Version:    0.7.0.1
 */