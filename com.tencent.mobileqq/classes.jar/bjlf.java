import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class bjlf
  implements View.OnClickListener
{
  public bjlf(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372813)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131709823), 0).a();
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
      vei.a("clk_effect", vei.b(avtd.a), 0, false, new String[0]);
      bihx.a.add(Integer.valueOf(7));
      continue;
      vei.a("clk_filter", vei.b(avtd.a), 0, false, new String[0]);
      bihx.a.add(Integer.valueOf(8));
      continue;
      vei.a("clk_music", vei.b(avtd.a), 0, false, new String[0]);
      bihx.a.add(Integer.valueOf(9));
      continue;
      vei.a("clk_face", vei.b(avtd.a), 0, false, new String[0]);
      bihx.a.add(Integer.valueOf(10));
      continue;
      vei.a("clk_beauty", vei.b(avtd.a), 0, false, new String[0]);
      bihx.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjlf
 * JD-Core Version:    0.7.0.1
 */