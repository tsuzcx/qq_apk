import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.qphone.base.util.QLog;

public class avvo
  implements View.OnClickListener
{
  public avvo(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      avtd.b();
      if (!axle.a(this.a.getContext())) {
        bcql.a(this.a.getContext(), ajya.a(2131708532), 0).a();
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (avte.a == 0)
        {
          bcql.a(this.a.getContext(), ajya.a(2131708538), 0).a();
          return;
        }
        if (avte.a != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
      return;
      if (avte.a == 2)
      {
        bool = avte.a(true);
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
      avtd.e();
      avtd.b();
      if (!axle.a(this.a.getContext()))
      {
        bcql.a(this.a.getContext(), ajya.a(2131708537), 0).a();
        return;
      }
      if (avte.a == 0)
      {
        bcql.a(this.a.getContext(), ajya.a(2131708536), 0).a();
        return;
      }
      if (avte.a != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
    return;
    if (avte.a == 2)
    {
      bool = avte.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).y();
      }
    }
    label334:
    if (i == 101) {
      avtd.d();
    }
    if (i == 104)
    {
      axqy.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
      avtd.c();
    }
    if (ProviderContainerView.a(this.a) != null) {
      ProviderContainerView.a(this.a).a();
    }
    ProviderContainerView.a(this.a, paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avvo
 * JD-Core Version:    0.7.0.1
 */