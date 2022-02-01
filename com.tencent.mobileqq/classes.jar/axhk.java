import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;

public class axhk
  extends RecyclerView.ItemDecoration
{
  private final int jdField_a_of_type_Int = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources());
  
  private axhk(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.top = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhk
 * JD-Core Version:    0.7.0.1
 */