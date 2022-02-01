import android.graphics.Rect;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class bqnq
  implements bqkk<bqkf>
{
  private final int jdField_a_of_type_Int = bqrh.b(DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  private bqnq(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(bqkf parambqkf, MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    if (LiuHaiUtils.b()) {}
    for (float f1 = LiuHaiUtils.e;; f1 = 0.0F)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(7);
      }
      float f2 = f1;
      if (blry.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext())) {
        f2 = f1 + blry.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext());
      }
      int i = (int)Math.abs(f4 - DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      int j;
      int k;
      int m;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        do
        {
          return false;
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
          if (DoodleLayout.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) {
            bqiu.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
          }
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          parambqkf = this.jdField_a_of_type_AndroidGraphicsRect;
          parambqkf.top -= this.jdField_a_of_type_Int;
          parambqkf = this.jdField_a_of_type_AndroidGraphicsRect;
          parambqkf.bottom += this.jdField_a_of_type_Int;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.getGlobalVisibleRect(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(4);
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, (int)f4);
          return false;
        } while (i <= DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()))
        {
          i = (int)f3;
          j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          k = (int)f4;
          m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          if ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f3, f4, null, f2)))
          {
            DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
            return false;
          }
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
          return false;
        }
        if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f3, (int)f4)))
        {
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
          return false;
        }
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        return false;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e())))
      {
        i = (int)f3;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
        k = (int)f4;
        m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
        if ((DoodleLayout.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f3, f4, null, f2))))
        {
          parambqkf.a();
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false, 0.0F, 0, 0, null, false, 0);
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "delete face, disable guideline");
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(0);
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        if ((DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) != null) || (DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) == null)) {
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false, false, false, false);
        return false;
        if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f3, (int)f4)))
        {
          parambqkf.a();
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        }
      }
      DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).a.a(Message.obtain(null, 17, 0, 0, new bqgd(false, false, false, false, true)));
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqnq
 * JD-Core Version:    0.7.0.1
 */