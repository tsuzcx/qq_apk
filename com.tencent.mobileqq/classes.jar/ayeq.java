import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.now.widget.SimpleCircleIndicator;

public class ayeq
  extends DataSetObserver
{
  public ayeq(SimpleCircleIndicator paramSimpleCircleIndicator, ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setCurrentItem(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayeq
 * JD-Core Version:    0.7.0.1
 */