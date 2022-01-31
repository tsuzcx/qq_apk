import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1.1;
import com.tencent.widget.AbsListView;

public class apsq
  implements bhpo
{
  public apsq(EmotionPanelViewPagerAdapter.1.1 param1) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter$1.jdField_a_of_type_Int == 1) {
        EmotionPanelViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter$1.this$0, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter$1.jdField_a_of_type_ComTencentWidgetListView);
      }
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsq
 * JD-Core Version:    0.7.0.1
 */