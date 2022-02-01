import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;

class aywd
  implements ViewPager.OnPageChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  aywd(aywc paramaywc) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramFloat > 0.4F))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        aywc.a(this.jdField_a_of_type_Aywc);
      }
      aywc.a(this.jdField_a_of_type_Aywc).setCurrentItem(2);
    }
    if (paramFloat == 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    aywc.a(this.jdField_a_of_type_Aywc, paramInt);
    aywc.a(this.jdField_a_of_type_Aywc, aywc.a(this.jdField_a_of_type_Aywc).a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywd
 * JD-Core Version:    0.7.0.1
 */