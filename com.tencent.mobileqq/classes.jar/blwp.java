import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class blwp
  implements View.OnClickListener
{
  public blwp(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373251)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131710195), 0).a();
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
      return;
      wta.a("clk_effect", wta.b(axlc.a), 0, false, new String[0]);
      bkjt.a.add(Integer.valueOf(7));
      continue;
      wta.a("clk_filter", wta.b(axlc.a), 0, false, new String[0]);
      bkjt.a.add(Integer.valueOf(8));
      continue;
      wta.a("clk_music", wta.b(axlc.a), 0, false, new String[0]);
      bkjt.a.add(Integer.valueOf(9));
      continue;
      wta.a("clk_face", wta.b(axlc.a), 0, false, new String[0]);
      bkjt.a.add(Integer.valueOf(10));
      continue;
      wta.a("clk_beauty", wta.b(axlc.a), 0, false, new String[0]);
      bkjt.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwp
 * JD-Core Version:    0.7.0.1
 */