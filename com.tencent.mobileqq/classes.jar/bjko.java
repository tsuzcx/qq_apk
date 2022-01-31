import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class bjko
  implements View.OnClickListener
{
  public bjko(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372811)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131709812), 0).a();
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
      vel.a("clk_effect", vel.b(avtb.a), 0, false, new String[0]);
      bihg.a.add(Integer.valueOf(7));
      continue;
      vel.a("clk_filter", vel.b(avtb.a), 0, false, new String[0]);
      bihg.a.add(Integer.valueOf(8));
      continue;
      vel.a("clk_music", vel.b(avtb.a), 0, false, new String[0]);
      bihg.a.add(Integer.valueOf(9));
      continue;
      vel.a("clk_face", vel.b(avtb.a), 0, false, new String[0]);
      bihg.a.add(Integer.valueOf(10));
      continue;
      vel.a("clk_beauty", vel.b(avtb.a), 0, false, new String[0]);
      bihg.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjko
 * JD-Core Version:    0.7.0.1
 */