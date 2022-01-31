import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class aruu
  implements View.OnClickListener
{
  public aruu(TabPageIndicator paramTabPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    TabPageIndicator.a(this.a, SystemClock.uptimeMillis());
    paramView = paramView.getTag();
    if ((paramView instanceof arux)) {}
    for (paramView = (arux)paramView;; paramView = null)
    {
      if (paramView == null) {}
      int j;
      do
      {
        return;
        int i = TabPageIndicator.a(this.a).a();
        j = paramView.jdField_a_of_type_Int;
        this.a.setCurrentItem(j);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        TabPageIndicator.a(this.a).setCurrentItem(j);
        if ((i == j) && (TabPageIndicator.a(this.a) != null)) {
          TabPageIndicator.a(this.a).a(j);
        }
      } while (TabPageIndicator.a(this.a) == null);
      TabPageIndicator.a(this.a).a(j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aruu
 * JD-Core Version:    0.7.0.1
 */