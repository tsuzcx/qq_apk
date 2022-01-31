import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;

class bati
  implements ValueAnimator.AnimatorUpdateListener
{
  bati(batg parambatg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.requestLayout();
    if (paramValueAnimator.intValue() <= -batg.jdField_a_of_type_Int + this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865))
    {
      if (this.a.jdField_a_of_type_Azno != null) {
        this.a.jdField_a_of_type_Azno.a(false);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bati
 * JD-Core Version:    0.7.0.1
 */