import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class bmbb
  implements View.OnClickListener
{
  public bmbb(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373303)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131710207), 0).a();
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
      wxj.a("clk_effect", wxj.b(axpl.a), 0, false, new String[0]);
      bkoa.a.add(Integer.valueOf(7));
      continue;
      wxj.a("clk_filter", wxj.b(axpl.a), 0, false, new String[0]);
      bkoa.a.add(Integer.valueOf(8));
      continue;
      wxj.a("clk_music", wxj.b(axpl.a), 0, false, new String[0]);
      bkoa.a.add(Integer.valueOf(9));
      continue;
      wxj.a("clk_face", wxj.b(axpl.a), 0, false, new String[0]);
      bkoa.a.add(Integer.valueOf(10));
      continue;
      wxj.a("clk_beauty", wxj.b(axpl.a), 0, false, new String[0]);
      bkoa.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbb
 * JD-Core Version:    0.7.0.1
 */