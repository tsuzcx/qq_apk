import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.qphone.base.util.QLog;

public class avvm
  implements View.OnClickListener
{
  public avvm(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      avtb.b();
      if (!axlc.a(this.a.getContext())) {
        bcpw.a(this.a.getContext(), ajyc.a(2131708521), 0).a();
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (avtc.a == 0)
        {
          bcpw.a(this.a.getContext(), ajyc.a(2131708527), 0).a();
          return;
        }
        if (avtc.a != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
      return;
      if (avtc.a == 2)
      {
        bool = avtc.a(true);
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
      avtb.e();
      avtb.b();
      if (!axlc.a(this.a.getContext()))
      {
        bcpw.a(this.a.getContext(), ajyc.a(2131708526), 0).a();
        return;
      }
      if (avtc.a == 0)
      {
        bcpw.a(this.a.getContext(), ajyc.a(2131708525), 0).a();
        return;
      }
      if (avtc.a != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
    return;
    if (avtc.a == 2)
    {
      bool = avtc.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).y();
      }
    }
    label334:
    if (i == 101) {
      avtb.d();
    }
    if (i == 104)
    {
      axqw.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
      avtb.c();
    }
    if (ProviderContainerView.a(this.a) != null) {
      ProviderContainerView.a(this.a).a();
    }
    ProviderContainerView.a(this.a, paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avvm
 * JD-Core Version:    0.7.0.1
 */