import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;

public class bmzf
  implements View.OnClickListener
{
  public bmzf(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373888)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131708924), 0).a();
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
        QLog.i("ProviderContainerView", 2, "onclick, index: " + i);
      }
      this.a.a(i, 0, null, false);
      if (QIMProviderContainerView.a(this.a) == null) {
        break;
      }
      QIMProviderContainerView.a(this.a).a();
      break;
      xwa.a("clk_effect", xwa.b(babc.a), 0, false, new String[0]);
      continue;
      xwa.a("clk_filter", xwa.b(babc.a), 0, false, new String[0]);
      continue;
      xwa.a("clk_music", xwa.b(babc.a), 0, false, new String[0]);
      continue;
      xwa.a("clk_face", xwa.b(babc.a), 0, false, new String[0]);
      continue;
      xwa.a("clk_beauty", xwa.b(babc.a), 0, false, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzf
 * JD-Core Version:    0.7.0.1
 */