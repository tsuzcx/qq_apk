import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class anbn
  implements View.OnTouchListener
{
  public anbn(EditProviderPart paramEditProviderPart) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (EditProviderPart.a(this.a) == null) {
      EditProviderPart.a(this.a, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
    }
    if (EditProviderPart.a(this.a).c()) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    while (((PasterDataManager)QIMManager.a(4)).a())
    {
      return false;
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.b = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.a.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.a.b) < 10.0F))
      {
        paramView = (EditDoodleExport)this.a.a(EditDoodleExport.class);
        if (paramView != null) {
          paramView.j_();
        }
      }
    }
    return EditProviderPart.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anbn
 * JD-Core Version:    0.7.0.1
 */