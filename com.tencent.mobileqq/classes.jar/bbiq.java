import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbiq
  implements View.OnClickListener
{
  public bbiq(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).a(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      bbgf.b();
      if (!bork.b(borf.b)) {
        QQToast.a(this.a.getContext(), anzj.a(2131707401), 0).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bbgg.a == 0)
      {
        QQToast.a(this.a.getContext(), anzj.a(2131707407), 0).a();
      }
      else if (bbgg.a == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
        }
      }
      else
      {
        boolean bool;
        if (bbgg.a == 2)
        {
          bool = bbgg.a(true);
          if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck soLoaded=" + bool);
          }
          if (ProviderContainerView.a(this.a) != null) {
            ProviderContainerView.a(this.a).y();
          }
        }
        if (i == 103)
        {
          bbgf.e();
          bbgf.b();
          if (!bork.b(borf.b))
          {
            QQToast.a(this.a.getContext(), anzj.a(2131707406), 0).a();
            continue;
          }
          if (bbgg.a == 0)
          {
            QQToast.a(this.a.getContext(), anzj.a(2131707405), 0).a();
            continue;
          }
          if (bbgg.a == -1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
            continue;
          }
          if (bbgg.a == 2)
          {
            bool = bbgg.a(true);
            if (QLog.isColorLevel()) {
              QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
            }
            if (ProviderContainerView.a(this.a) != null) {
              ProviderContainerView.a(this.a).y();
            }
          }
        }
        if (i == 101) {
          bbgf.d();
        }
        if (i == 104)
        {
          bdll.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
          bbgf.c();
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
 * Qualified Name:     bbiq
 * JD-Core Version:    0.7.0.1
 */