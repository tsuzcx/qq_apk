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

public class bouf
  implements View.OnClickListener
{
  public bouf(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374003)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131708583), 0).a();
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
      yqu.a("clk_effect", yqu.b(banm.a), 0, false, new String[0]);
      bncn.a.add(Integer.valueOf(7));
      continue;
      yqu.a("clk_filter", yqu.b(banm.a), 0, false, new String[0]);
      bncn.a.add(Integer.valueOf(8));
      continue;
      yqu.a("clk_music", yqu.b(banm.a), 0, false, new String[0]);
      bncn.a.add(Integer.valueOf(9));
      continue;
      yqu.a("clk_face", yqu.b(banm.a), 0, false, new String[0]);
      bncn.a.add(Integer.valueOf(10));
      continue;
      yqu.a("clk_beauty", yqu.b(banm.a), 0, false, new String[0]);
      bncn.a.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bouf
 * JD-Core Version:    0.7.0.1
 */