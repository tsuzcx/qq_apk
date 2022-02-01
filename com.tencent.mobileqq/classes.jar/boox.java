import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;

public class boox
  implements View.OnClickListener
{
  public boox(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374117)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131709271), 0).a();
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
      ykv.a("clk_effect", ykv.b(bbhl.a), 0, false, new String[0]);
      continue;
      ykv.a("clk_filter", ykv.b(bbhl.a), 0, false, new String[0]);
      continue;
      ykv.a("clk_music", ykv.b(bbhl.a), 0, false, new String[0]);
      continue;
      ykv.a("clk_face", ykv.b(bbhl.a), 0, false, new String[0]);
      continue;
      ykv.a("clk_beauty", ykv.b(bbhl.a), 0, false, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boox
 * JD-Core Version:    0.7.0.1
 */