import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class bpwa
  implements View.OnClickListener
{
  public bpwa(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374142)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131708692), 0).a();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("ProviderContainerView", 2, "onclick, indext: " + i);
      }
      this.a.a(i, 0, null, false);
      if (QIMProviderContainerView.a(this.a) == null) {
        break;
      }
      QIMProviderContainerView.a(this.a).g();
      break;
      yup.a("clk_effect", yup.b(bbgf.a), 0, false, new String[0]);
      bodv.a.add(Integer.valueOf(7));
      continue;
      yup.a("clk_filter", yup.b(bbgf.a), 0, false, new String[0]);
      bodv.a.add(Integer.valueOf(8));
      continue;
      yup.a("clk_music", yup.b(bbgf.a), 0, false, new String[0]);
      bodv.a.add(Integer.valueOf(9));
      continue;
      yup.a("clk_face", yup.b(bbgf.a), 0, false, new String[0]);
      bodv.a.add(Integer.valueOf(10));
      continue;
      yup.a("clk_beauty", yup.b(bbgf.a), 0, false, new String[0]);
      bodv.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwa
 * JD-Core Version:    0.7.0.1
 */