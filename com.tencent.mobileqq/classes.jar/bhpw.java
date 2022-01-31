import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class bhpw
  implements View.OnClickListener
{
  public bhpw(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131307099)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131644027), 0).a();
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
      urp.a("clk_effect", urp.b(auts.a), 0, false, new String[0]);
      bheq.a.add(Integer.valueOf(7));
      continue;
      urp.a("clk_filter", urp.b(auts.a), 0, false, new String[0]);
      bheq.a.add(Integer.valueOf(8));
      continue;
      urp.a("clk_music", urp.b(auts.a), 0, false, new String[0]);
      bheq.a.add(Integer.valueOf(9));
      continue;
      urp.a("clk_face", urp.b(auts.a), 0, false, new String[0]);
      bheq.a.add(Integer.valueOf(10));
      continue;
      urp.a("clk_beauty", urp.b(auts.a), 0, false, new String[0]);
      bheq.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhpw
 * JD-Core Version:    0.7.0.1
 */