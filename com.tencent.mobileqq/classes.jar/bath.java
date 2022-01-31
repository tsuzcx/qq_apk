import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.common.config.AppSetting;

class bath
  implements ValueAnimator.AnimatorUpdateListener
{
  bath(batg parambatg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.requestLayout();
    if ((paramValueAnimator.intValue() >= this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865)) && (AppSetting.d) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount() > 0))
    {
      paramValueAnimator = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(0);
      if (paramValueAnimator != null) {
        paramValueAnimator.requestFocusFromTouch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bath
 * JD-Core Version:    0.7.0.1
 */