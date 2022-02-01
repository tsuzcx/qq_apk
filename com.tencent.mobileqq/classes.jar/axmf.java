import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axmf
  implements View.OnClickListener
{
  public axmf(TabPageIndicator paramTabPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    TabPageIndicator.a(this.a, SystemClock.uptimeMillis());
    Object localObject = paramView.getTag();
    if ((localObject instanceof axmi)) {}
    for (localObject = (axmi)localObject;; localObject = null)
    {
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        int i = TabPageIndicator.a(this.a).a();
        int j = ((axmi)localObject).jdField_a_of_type_Int;
        this.a.setCurrentItem(j);
        ((axmi)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        TabPageIndicator.a(this.a).setCurrentItem(j);
        if ((i == j) && (TabPageIndicator.a(this.a) != null)) {
          TabPageIndicator.a(this.a).a(j);
        }
        if (TabPageIndicator.a(this.a) != null) {
          TabPageIndicator.a(this.a).a(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmf
 * JD-Core Version:    0.7.0.1
 */