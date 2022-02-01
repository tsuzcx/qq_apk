import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.ProviderContainerView;

public class bmyv
  implements View.OnClickListener
{
  public bmyv(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    int j = ProviderContainerView.a(this.a).c(i);
    if (j == 102) {
      ProviderContainerView.a(this.a).b();
    }
    for (;;)
    {
      this.a.b(j);
      if (QLog.isColorLevel()) {
        QLog.i("ProviderContainerView", 2, "onclick, index: " + i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyv
 * JD-Core Version:    0.7.0.1
 */