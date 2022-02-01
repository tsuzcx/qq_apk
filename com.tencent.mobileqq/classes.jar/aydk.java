import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;

class aydk
  implements ViewPager.OnPageChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  aydk(aydj paramaydj) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramFloat > 0.4F))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        aydj.a(this.jdField_a_of_type_Aydj);
      }
      aydj.a(this.jdField_a_of_type_Aydj).setCurrentItem(2);
    }
    if (paramFloat == 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    aydj.a(this.jdField_a_of_type_Aydj, paramInt);
    aydj.a(this.jdField_a_of_type_Aydj, aydj.a(this.jdField_a_of_type_Aydj).a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydk
 * JD-Core Version:    0.7.0.1
 */