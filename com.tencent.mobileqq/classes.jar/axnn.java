import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class axnn
  implements View.OnClickListener
{
  public axnn(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      axlc.b();
      if (!azgk.a(this.a.getContext())) {
        QQToast.a(this.a.getContext(), alpo.a(2131708904), 0).a();
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (axld.a == 0)
        {
          QQToast.a(this.a.getContext(), alpo.a(2131708910), 0).a();
          return;
        }
        if (axld.a != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
      return;
      if (axld.a == 2)
      {
        bool = axld.a(true);
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
      axlc.e();
      axlc.b();
      if (!azgk.a(this.a.getContext()))
      {
        QQToast.a(this.a.getContext(), alpo.a(2131708909), 0).a();
        return;
      }
      if (axld.a == 0)
      {
        QQToast.a(this.a.getContext(), alpo.a(2131708908), 0).a();
        return;
      }
      if (axld.a != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
    return;
    if (axld.a == 2)
    {
      bool = axld.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).y();
      }
    }
    label334:
    if (i == 101) {
      axlc.d();
    }
    if (i == 104)
    {
      azmj.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
      axlc.c();
    }
    if (ProviderContainerView.a(this.a) != null) {
      ProviderContainerView.a(this.a).a();
    }
    ProviderContainerView.a(this.a, paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axnn
 * JD-Core Version:    0.7.0.1
 */