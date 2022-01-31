import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter;

public class audc
  implements ViewPager.OnPageChangeListener
{
  public audc(SearchResultFragment paramSearchResultFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setCurrentTab(paramInt);
    if (this.a.jdField_a_of_type_Int != paramInt) {
      this.a.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter.a(paramInt);
    }
    this.a.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audc
 * JD-Core Version:    0.7.0.1
 */