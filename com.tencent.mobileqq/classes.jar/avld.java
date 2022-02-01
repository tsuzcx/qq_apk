import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;

public class avld
  extends RecyclerView.OnScrollListener
  implements avoq
{
  private int jdField_a_of_type_Int = 0;
  private avop jdField_a_of_type_Avop = new avop(200, this);
  private EmotionPanelListView.PullAndFastScrollListener jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
  
  public avld(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener = paramPullAndFastScrollListener;
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.jdField_a_of_type_Avop.a(true);
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener.onPullDown();
      }
    }
  }
  
  public void onCheckSpeed(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener.onPullUp();
      this.jdField_a_of_type_Avop.a(false);
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.jdField_a_of_type_Int == 2) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener.onPullDown();
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.jdField_a_of_type_Avop.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avld
 * JD-Core Version:    0.7.0.1
 */