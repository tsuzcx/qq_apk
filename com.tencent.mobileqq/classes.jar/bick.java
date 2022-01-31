import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class bick
  implements View.OnTouchListener
{
  bick(bicj parambicj) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (bicj.a(this.a) == null)
    {
      if (this.a.jdField_a_of_type_Bigb.a == null) {
        return false;
      }
      bicj.a(this.a, this.a.jdField_a_of_type_Bigb.a.a());
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
    }
    if (bicj.a(this.a).c()) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    while ((this.a.jdField_a_of_type_Boolean) || (bicj.a(this.a).getVisibility() == 8))
    {
      return false;
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.b = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.a.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.a.b) < 10.0F))
      {
        paramView = (bibg)this.a.a(bibg.class);
        if (paramView != null) {
          paramView.g_();
        }
      }
    }
    return bicj.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bick
 * JD-Core Version:    0.7.0.1
 */