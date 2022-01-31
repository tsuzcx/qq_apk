import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class aujm
  implements View.OnClickListener
{
  public aujm(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    MultiCardPageIndicator.a(this.a, SystemClock.uptimeMillis());
    paramView = paramView.getTag();
    if ((paramView instanceof aujp)) {}
    for (paramView = (aujp)paramView;; paramView = null)
    {
      if (paramView == null) {}
      int j;
      do
      {
        return;
        int i = MultiCardPageIndicator.a(this.a).a();
        j = paramView.jdField_a_of_type_Int;
        this.a.setCurrentItem(j);
        azmj.b(null, "dc00898", "", "", "0X800A216", "0X800A216", 0, 0, "", "", "", "");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        MultiCardPageIndicator.a(this.a).setCurrentItem(j);
        if ((i == j) && (MultiCardPageIndicator.a(this.a) != null)) {
          MultiCardPageIndicator.a(this.a).a(j);
        }
      } while (MultiCardPageIndicator.a(this.a) == null);
      MultiCardPageIndicator.a(this.a).a(j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujm
 * JD-Core Version:    0.7.0.1
 */