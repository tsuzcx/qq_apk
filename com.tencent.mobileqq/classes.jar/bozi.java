import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class bozi
  implements bowo<bowb>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  
  private bozi(DoodleLayout paramDoodleLayout) {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, System.currentTimeMillis() + 500L);
    if (paramBoolean3) {
      DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) + 500L);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setAnimationListener(new bozj(this));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean3) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new bozk(this));
    if (paramBoolean2) {
      localObject = localAlphaAnimation;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation((Animation)localObject);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimationEndTime(DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bozc != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bozc.b((Animation)localObject);
      }
      return;
    }
  }
  
  public boolean a(bowb parambowb, MotionEvent paramMotionEvent)
  {
    bphx localbphx = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
    if (localbphx != null) {}
    int i;
    int j;
    switch (localbphx.jdField_a_of_type_Int)
    {
    default: 
      i = Math.round(paramMotionEvent.getY());
      j = Math.round(paramMotionEvent.getX());
      switch (paramMotionEvent.getAction())
      {
      }
      break;
    }
    label516:
    do
    {
      do
      {
        do
        {
          return false;
          i = localbphx.b;
          if (i != bpau.jdField_a_of_type_Int) {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.put(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c, true);
          }
          for (;;)
          {
            localObject = (bpau)parambowb.a(101);
            if (localObject != null) {
              ((bpau)localObject).a(i);
            }
            if (parambowb.b()) {
              break;
            }
            parambowb.g();
            break;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.put(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c, false);
          }
          if (parambowb.c()) {
            break;
          }
          parambowb.f();
          break;
          Object localObject = null;
          if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext() instanceof QQStoryBaseActivity)) {
            localObject = ((QQStoryBaseActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext()).a;
          }
          parambowb.a((AppInterface)localObject, 2, localbphx.b);
          break;
          this.jdField_a_of_type_Int = Math.round(paramMotionEvent.getX());
          this.b = Math.round(paramMotionEvent.getY());
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          return false;
        } while (((Math.abs(j - this.jdField_a_of_type_Int) < 3) && (Math.abs(i - this.b) < 3)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d == 6) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d == 5));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5);
        if (DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) > System.currentTimeMillis()) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(false));
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Personality", 2, "LineLayer draw move hide");
          return false;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(true));
          a(true, false, true);
        }
        if (parambowb.a.b() > 0) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d != 5) {
          break label516;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a(true, true, true);
      } while (!QLog.isColorLevel());
      QLog.d("Personality", 2, "LineLayer draw up show");
      return false;
    } while ((Math.abs(j - this.jdField_a_of_type_Int) >= 3) || (Math.abs(i - this.b) >= 3));
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d == 6)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(2, Boolean.valueOf(false));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(2);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      if (parambowb.a.b() > 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, true, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Personality", 2, "LineLayer tap up show");
        return false;
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(6);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(6);
    ykw.b("0X80080E5", ykw.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    if (parambowb.a.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, false, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Personality", 2, "LineLayer tap up hide");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozi
 * JD-Core Version:    0.7.0.1
 */