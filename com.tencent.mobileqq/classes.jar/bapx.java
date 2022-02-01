import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bapx
  implements View.OnClickListener
{
  public bapx(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      banm.b();
      if (!bnpy.b(bnpt.b)) {
        QQToast.a(this.a.getContext(), anni.a(2131707292), 0).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bann.a == 0)
      {
        QQToast.a(this.a.getContext(), anni.a(2131707298), 0).a();
      }
      else if (bann.a == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
        }
      }
      else
      {
        boolean bool;
        if (bann.a == 2)
        {
          bool = bann.a(true);
          if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck soLoaded=" + bool);
          }
          if (ProviderContainerView.a(this.a) != null) {
            ProviderContainerView.a(this.a).y();
          }
        }
        if (i == 103)
        {
          banm.e();
          banm.b();
          if (!bnpy.b(bnpt.b))
          {
            QQToast.a(this.a.getContext(), anni.a(2131707297), 0).a();
            continue;
          }
          if (bann.a == 0)
          {
            QQToast.a(this.a.getContext(), anni.a(2131707296), 0).a();
            continue;
          }
          if (bann.a == -1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
            continue;
          }
          if (bann.a == 2)
          {
            bool = bann.a(true);
            if (QLog.isColorLevel()) {
              QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
            }
            if (ProviderContainerView.a(this.a) != null) {
              ProviderContainerView.a(this.a).y();
            }
          }
        }
        if (i == 101) {
          banm.d();
        }
        if (i == 104)
        {
          bcst.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
          banm.c();
        }
        if (ProviderContainerView.a(this.a) != null) {
          ProviderContainerView.a(this.a).a();
        }
        ProviderContainerView.a(this.a, paramView, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapx
 * JD-Core Version:    0.7.0.1
 */