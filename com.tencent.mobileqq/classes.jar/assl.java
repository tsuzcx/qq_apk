import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1;
import com.tencent.widget.AbsListView;

public class assl
  implements blih
{
  public assl(SystemAndEmojiUniversalPanel.1.1 param1) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemAndEmojiUniversalPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$1.this$0, paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      SystemAndEmojiUniversalPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$1.this$0, this.a.jdField_a_of_type_JavaUtilList, SystemAndEmojiUniversalPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$1.this$0));
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assl
 * JD-Core Version:    0.7.0.1
 */