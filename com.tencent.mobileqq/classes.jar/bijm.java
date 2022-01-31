import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class bijm
  extends bika
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bijn a;
  public bira a;
  public birb a;
  public boolean a;
  public birb b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bijm.class.getSimpleName();
  }
  
  public bijm(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bira = new bira();
    this.jdField_a_of_type_Bira.a(true);
    this.jdField_a_of_type_Bira.a(6.0F);
    this.jdField_a_of_type_Bira.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, f1, f2)) {
      this.jdField_a_of_type_Birb.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bira.e(this.jdField_a_of_type_Birb, f1, f2))
      {
        this.jdField_a_of_type_Birb.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bira.b(this.jdField_a_of_type_Birb, f1, f2));
    this.jdField_a_of_type_Birb.jdField_k_of_type_Int = 2;
  }
  
  private void a(bijy parambijy)
  {
    if (parambijy == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bira.a(parambijy, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bira.a(parambijy, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bira.b(parambijy, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambijy.e = parambijy.w;
      parambijy.jdField_a_of_type_AndroidGraphicsPointF = parambijy.jdField_b_of_type_AndroidGraphicsPointF;
      parambijy.jdField_a_of_type_Float = parambijy.q;
      parambijy.jdField_b_of_type_Float = parambijy.r;
      parambijy.c = parambijy.s;
      parambijy.d = parambijy.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambijy.l, parambijy.r, parambijy.s, parambijy.t, parambijy.jdField_b_of_type_AndroidGraphicsPointF, parambijy.m, 0);
      if (this.jdField_a_of_type_Bijn == null) {
        break;
      }
      this.jdField_a_of_type_Bijn.a(bool1, bool2, false, bool3, parambijy.l);
      return;
      parambijy.w = parambijy.e;
      parambijy.jdField_b_of_type_AndroidGraphicsPointF = parambijy.jdField_a_of_type_AndroidGraphicsPointF;
      parambijy.q = parambijy.jdField_a_of_type_Float;
      parambijy.r = parambijy.jdField_b_of_type_Float;
      if (bool3)
      {
        parambijy.t = parambijy.d;
        if ((!bool1) && (!bool2)) {
          parambijy.c = parambijy.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambijy.s = parambijy.c;
        if (!bool3) {
          parambijy.d = parambijy.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(birb parambirb, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambirb instanceof bijj)) && (!(parambirb instanceof bijy))) || (!((bijy)this.jdField_a_of_type_Birb).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bira.e(this.jdField_a_of_type_Birb, f1, f2)) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (!bool2) {
        break label133;
      }
      if (!this.jdField_a_of_type_Bira.b(this.jdField_a_of_type_Birb, f1, f2)) {
        break;
      }
      return false;
      bool1 = false;
      break label68;
    }
    label133:
    return bool2;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, f1, f2)) {
      if (this.jdField_a_of_type_Bijn != null)
      {
        if (!(this.jdField_a_of_type_Birb instanceof bijr)) {
          break label77;
        }
        paramMotionEvent = ((bijr)this.jdField_a_of_type_Birb).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb, paramMotionEvent.b(), 2);
        }
      }
    }
    label77:
    DynamicTextItem localDynamicTextItem;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bira.e(this.jdField_a_of_type_Birb, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bijn == null);
            this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb);
            return;
            if (!this.jdField_a_of_type_Bira.b(this.jdField_a_of_type_Birb, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bijn == null);
          this.jdField_a_of_type_Bijn.b(this.jdField_a_of_type_Birb);
          return;
          if (!this.jdField_a_of_type_Bira.c(this.jdField_a_of_type_Birb, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Birb.g) {
            this.jdField_a_of_type_Birb.g = true;
          }
        } while (this.jdField_a_of_type_Bijn == null);
        this.jdField_a_of_type_Bijn.b(this.jdField_a_of_type_Birb, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, f1, f2, true)) || (this.jdField_a_of_type_Bijn == null) || (this.jdField_a_of_type_Birb == null));
      if (!(this.jdField_a_of_type_Birb instanceof bijr)) {
        break;
      }
      localDynamicTextItem = ((bijr)this.jdField_a_of_type_Birb).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bijr)this.jdField_a_of_type_Birb, this.jdField_a_of_type_Bira);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb, localDynamicTextItem.b(), 0, f1, f2);
    return;
    urk.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Birb);
    this.jdField_a_of_type_Bijn.a(this.jdField_a_of_type_Birb, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(birb parambirb)
  {
    boolean bool1 = this.jdField_a_of_type_Bira.a(parambirb, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bira.a(parambirb, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bira.b(parambirb, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bijn != null) {
      this.jdField_a_of_type_Bijn.a(bool1, bool2, false, bool3, parambirb.l);
    }
    if (parambirb != null)
    {
      if (parambirb.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambirb.l, parambirb.r, parambirb.s, parambirb.t, parambirb.jdField_b_of_type_AndroidGraphicsPointF, parambirb.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambirb.l, parambirb.r, parambirb.s, parambirb.t, parambirb.jdField_b_of_type_AndroidGraphicsPointF, parambirb.m, 1);
  }
  
  private void e(birb parambirb)
  {
    if ((parambirb == null) || (parambirb.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambirb instanceof bijj))
      {
        urp.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambirb instanceof bijy));
    urp.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public birb a()
  {
    return this.jdField_a_of_type_Birb;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Birb);
    this.jdField_a_of_type_Birb = null;
    this.jdField_a_of_type_Bira.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Birb == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Birb.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bijn parambijn)
  {
    this.jdField_a_of_type_Bijn = parambijn;
  }
  
  public void a(birb parambirb)
  {
    this.jdField_a_of_type_Birb = parambirb;
    if (this.jdField_a_of_type_Birb == null) {}
    do
    {
      return;
      bijo.c(true);
      if ((this.jdField_a_of_type_Birb instanceof bijr))
      {
        this.jdField_a_of_type_Bira.a(6.0F);
        this.jdField_a_of_type_Bira.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Birb instanceof bijc)) || ((this.jdField_a_of_type_Birb instanceof biiz)))
      {
        this.jdField_a_of_type_Bira.a(18.0F);
        this.jdField_a_of_type_Bira.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Birb instanceof bijy));
    this.jdField_a_of_type_Bira.a(18.0F);
    this.jdField_a_of_type_Bira.b(0.5F);
    ((bijy)this.jdField_a_of_type_Birb).jdField_a_of_type_Biyc.a((bijy)this.jdField_a_of_type_Birb, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void b(birb parambirb)
  {
    if (parambirb == null) {}
    while ((parambirb.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambirb.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    urk.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambirb.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Birb != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Birb);
    this.jdField_a_of_type_Birb = null;
    bijo.c(false);
    k();
  }
  
  public void c(birb parambirb)
  {
    if (parambirb == null) {
      return;
    }
    parambirb.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Birb != null) {
      parambirb.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Birb.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambirb instanceof bijc)) && ((((bijc)parambirb).h == 1) || (((bijc)parambirb).h == 3))) {
      ((bijc)parambirb).a.setCallback(this);
    }
    this.jdField_a_of_type_Birb = parambirb;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bikb != null) && (a(this.jdField_a_of_type_Birb, paramMotionEvent))) {
      this.jdField_a_of_type_Bikb.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bira.a(paramMotionEvent, true);
      if (i == 0) {
        d();
      }
      break;
    }
    do
    {
      return true;
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Birb != null) {
        this.jdField_a_of_type_Bira.a(this.jdField_a_of_type_Birb);
      }
      if (this.jdField_a_of_type_Birb != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Birb == null) || (this.jdField_a_of_type_Birb.e != true) || (!this.jdField_a_of_type_Birb.g) || (this.jdField_a_of_type_Birb.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Birb.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      urk.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Birb.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      i = 1;
      break label86;
      if (k > 10) {
        this.jdField_a_of_type_Boolean = true;
      }
      i = 1;
      break label86;
      if (!this.jdField_a_of_type_Boolean) {
        b(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Birb != null)) {
        e(this.jdField_a_of_type_Birb);
      }
      if (this.jdField_a_of_type_Birb != null) {
        this.jdField_a_of_type_Birb.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Birb != null) {
        this.jdField_a_of_type_Birb.e = false;
      }
      this.jdField_a_of_type_Bira.a();
      break label86;
      if (((this.jdField_a_of_type_Birb instanceof bijc)) || ((this.jdField_a_of_type_Birb instanceof bijr)))
      {
        d(this.jdField_a_of_type_Birb);
        return true;
      }
    } while (!(this.jdField_a_of_type_Birb instanceof bijy));
    a((bijy)this.jdField_a_of_type_Birb);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    k();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijm
 * JD-Core Version:    0.7.0.1
 */