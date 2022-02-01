import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class bosr
  implements View.OnTouchListener
{
  bosr(bosq parambosq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (bosq.a(this.a) == null)
    {
      if (this.a.jdField_a_of_type_Botw.a == null) {
        return false;
      }
      bosq.a(this.a, this.a.jdField_a_of_type_Botw.a.a());
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
    }
    if (bosq.a(this.a).c()) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    while ((this.a.jdField_a_of_type_Boolean) || (bosq.a(this.a).getVisibility() == 8))
    {
      return false;
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.b = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.a.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.a.b) < 10.0F))
      {
        paramView = (bors)this.a.a(bors.class);
        if (paramView != null) {
          paramView.b();
        }
      }
    }
    return bosq.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosr
 * JD-Core Version:    0.7.0.1
 */