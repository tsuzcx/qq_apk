import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class bncz
  implements View.OnTouchListener
{
  bncz(bncy parambncy) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (bncy.a(this.a) == null)
    {
      if (this.a.jdField_a_of_type_Bnee.a == null) {
        return false;
      }
      bncy.a(this.a, this.a.jdField_a_of_type_Bnee.a.a());
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
    }
    if (bncy.a(this.a).c()) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    while ((this.a.jdField_a_of_type_Boolean) || (bncy.a(this.a).getVisibility() == 8))
    {
      return false;
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.b = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.a.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.a.b) < 10.0F))
      {
        paramView = (bnca)this.a.a(bnca.class);
        if (paramView != null) {
          paramView.b();
        }
      }
    }
    return bncy.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncz
 * JD-Core Version:    0.7.0.1
 */