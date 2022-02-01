import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2;
import com.tencent.widget.AbsListView;

public class aspx
  implements blih
{
  public aspx(EmotionPanelViewPagerAdapter.2 param2) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      if (this.a.jdField_a_of_type_Int == 1) {
        EmotionPanelViewPagerAdapter.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_a_of_type_ComTencentWidgetListView);
      }
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspx
 * JD-Core Version:    0.7.0.1
 */