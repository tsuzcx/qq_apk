import android.graphics.Rect;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bmqb
  implements bmmx<bmmw>
{
  private final int jdField_a_of_type_Int = bmtu.b(DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bmqb(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(bmmw parambmmw, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((parambmmw instanceof bmlu)) {
      localRect = new Rect();
    }
    for (Rect localRect = ((bmlu)parambmmw).a(localRect);; localRect = null)
    {
      if (bngs.b()) {}
      for (float f1 = bngs.e;; f1 = 0.0F)
      {
        float f2 = f1;
        if (bhzc.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext())) {
          f2 = f1 + bhzc.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext());
        }
        f1 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        int i = (int)Math.abs(f3 - DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
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
              bmlh.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            }
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
            parambmmw = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmmw.top -= this.jdField_a_of_type_Int;
            parambmmw = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmmw.bottom += this.jdField_a_of_type_Int;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(4);
            DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, (int)f3);
            this.jdField_a_of_type_Boolean = false;
            return false;
          } while ((i <= DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) || (this.jdField_a_of_type_AndroidGraphicsRect == null));
          if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()))
          {
            i = (int)f1;
            j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
            k = (int)f3;
            m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
            if ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f3, localRect, f2)))
            {
              DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
              this.jdField_a_of_type_Boolean = true;
            }
          }
          for (;;)
          {
            this.b = true;
            return false;
            DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
            this.jdField_a_of_type_Boolean = false;
            continue;
            if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f3)) && (DoodleLayout.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)))
            {
              DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
              this.jdField_a_of_type_Boolean = true;
            }
            else
            {
              DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e())))
        {
          i = (int)f1;
          j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          k = (int)f3;
          m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          if ((DoodleLayout.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f3, localRect, f2))))
          {
            if ((parambmmw instanceof bmlu))
            {
              wsv.b("DoodleLayout", "remove face.");
              ((bmlu)parambmmw).c();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false, 0.0F, 0, 0, null, false, 0);
              if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "delete face, disable guideline");
              }
              DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
            }
          }
          else
          {
            label710:
            if ((!DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) || (DoodleLayout.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) || (!(parambmmw instanceof bmls))) {
              break label1149;
            }
            parambmmw = (bmls)parambmmw;
            paramMotionEvent = parambmmw.jdField_a_of_type_Bmly;
            if ((!parambmmw.jdField_a_of_type_Bmtw.a(paramMotionEvent, f1, f3, false)) || (parambmmw.jdField_a_of_type_Boolean) || (!paramMotionEvent.b) || (paramMotionEvent.c)) {
              break label1149;
            }
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramMotionEvent);
          }
        }
        label854:
        label1143:
        label1149:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(0);
          }
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
          if ((DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) == null) && (DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) != null))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false, false, false, false);
            if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b) || (!this.b)) {
              break label1143;
            }
          }
          for (;;)
          {
            DoodleLayout.d(bool);
            this.b = false;
            return false;
            if ((parambmmw instanceof bmmk))
            {
              wsv.b("DoodleLayout", "editpic remove text.");
              ((bmmk)parambmmw).h();
              parambmmw.d(false);
              break;
            }
            if (!(parambmmw instanceof bmmi)) {
              break;
            }
            paramMotionEvent = ((bmmi)parambmmw).a();
            DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, paramMotionEvent);
            ((bmmi)parambmmw).c();
            break;
            if ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_AndroidGraphicsRect == null) || (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f3)) || (!this.jdField_a_of_type_Boolean)) {
              break label710;
            }
            if ((parambmmw instanceof bmmk))
            {
              wsv.b("DoodleLayout", "remove text.");
              ((bmmk)parambmmw).h();
              parambmmw.d(false);
            }
            for (;;)
            {
              DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
              break;
              if ((parambmmw instanceof bmlu))
              {
                wsv.b("DoodleLayout", "remove face.");
                ((bmlu)parambmmw).c();
              }
              else if ((parambmmw instanceof bmmi))
              {
                paramMotionEvent = ((bmmi)parambmmw).a();
                DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, paramMotionEvent);
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(((bmmi)parambmmw).a(), 0);
                ((bmmi)parambmmw).c();
              }
            }
            DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).a.a(Message.obtain(null, 17, 0, 0, new bmiq(false, false, false, false, true)));
            break label854;
            bool = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqb
 * JD-Core Version:    0.7.0.1
 */