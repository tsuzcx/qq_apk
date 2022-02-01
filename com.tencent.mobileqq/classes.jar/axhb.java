import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axhb
  implements View.OnClickListener
{
  public axhb(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    MultiCardPageIndicator.a(this.a, SystemClock.uptimeMillis());
    Object localObject = paramView.getTag();
    if ((localObject instanceof axhe)) {}
    for (localObject = (axhe)localObject;; localObject = null)
    {
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        int i = MultiCardPageIndicator.a(this.a).a();
        int j = ((axhe)localObject).jdField_a_of_type_Int;
        this.a.setCurrentItem(j);
        bdla.b(null, "dc00898", "", "", "0X800A216", "0X800A216", 0, 0, "", "", "", "");
        ((axhe)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        MultiCardPageIndicator.a(this.a).setCurrentItem(j);
        if ((i == j) && (MultiCardPageIndicator.a(this.a) != null)) {
          MultiCardPageIndicator.a(this.a).a(j);
        }
        if (MultiCardPageIndicator.a(this.a) != null) {
          MultiCardPageIndicator.a(this.a).a(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhb
 * JD-Core Version:    0.7.0.1
 */