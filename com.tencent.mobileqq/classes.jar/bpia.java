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

public class bpia
  extends bpio
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bpib a;
  public bppo a;
  public bppp a;
  public boolean a;
  public bppp b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bpia.class.getSimpleName();
  }
  
  public bpia(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bppo = new bppo();
    this.jdField_a_of_type_Bppo.a(true);
    this.jdField_a_of_type_Bppo.a(6.0F);
    this.jdField_a_of_type_Bppo.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, f1, f2)) {
      this.jdField_a_of_type_Bppp.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bppo.e(this.jdField_a_of_type_Bppp, f1, f2))
      {
        this.jdField_a_of_type_Bppp.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bppo.b(this.jdField_a_of_type_Bppp, f1, f2));
    this.jdField_a_of_type_Bppp.jdField_k_of_type_Int = 2;
  }
  
  private void a(bpim parambpim)
  {
    if (parambpim == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bppo.a(parambpim, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bppo.a(parambpim, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bppo.b(parambpim, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambpim.e = parambpim.w;
      parambpim.jdField_a_of_type_AndroidGraphicsPointF = parambpim.jdField_b_of_type_AndroidGraphicsPointF;
      parambpim.jdField_a_of_type_Float = parambpim.q;
      parambpim.jdField_b_of_type_Float = parambpim.r;
      parambpim.c = parambpim.s;
      parambpim.d = parambpim.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambpim.l, parambpim.r, parambpim.s, parambpim.t, parambpim.jdField_b_of_type_AndroidGraphicsPointF, parambpim.m, 0);
      if (this.jdField_a_of_type_Bpib == null) {
        break;
      }
      this.jdField_a_of_type_Bpib.a(bool1, bool2, false, bool3, parambpim.l);
      return;
      parambpim.w = parambpim.e;
      parambpim.jdField_b_of_type_AndroidGraphicsPointF = parambpim.jdField_a_of_type_AndroidGraphicsPointF;
      parambpim.q = parambpim.jdField_a_of_type_Float;
      parambpim.r = parambpim.jdField_b_of_type_Float;
      if (bool3)
      {
        parambpim.t = parambpim.d;
        if ((!bool1) && (!bool2)) {
          parambpim.c = parambpim.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambpim.s = parambpim.c;
        if (!bool3) {
          parambpim.d = parambpim.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bppp parambppp, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambppp instanceof bphx)) && (!(parambppp instanceof bpim))) || (!((bpim)this.jdField_a_of_type_Bppp).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bppo.e(this.jdField_a_of_type_Bppp, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bppo.b(this.jdField_a_of_type_Bppp, f1, f2)) {
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
    if (this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, f1, f2)) {
      if (this.jdField_a_of_type_Bpib != null)
      {
        if (!(this.jdField_a_of_type_Bppp instanceof bpif)) {
          break label77;
        }
        paramMotionEvent = ((bpif)this.jdField_a_of_type_Bppp).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bppo.e(this.jdField_a_of_type_Bppp, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bpib == null);
            this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp);
            return;
            if (!this.jdField_a_of_type_Bppo.b(this.jdField_a_of_type_Bppp, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bpib == null);
          this.jdField_a_of_type_Bpib.b(this.jdField_a_of_type_Bppp);
          return;
          if (!this.jdField_a_of_type_Bppo.c(this.jdField_a_of_type_Bppp, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bppp.g) {
            this.jdField_a_of_type_Bppp.g = true;
          }
        } while (this.jdField_a_of_type_Bpib == null);
        this.jdField_a_of_type_Bpib.b(this.jdField_a_of_type_Bppp, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, f1, f2, true)) || (this.jdField_a_of_type_Bpib == null) || (this.jdField_a_of_type_Bppp == null));
      if (!(this.jdField_a_of_type_Bppp instanceof bpif)) {
        break;
      }
      localDynamicTextItem = ((bpif)this.jdField_a_of_type_Bppp).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bpif)this.jdField_a_of_type_Bppp, this.jdField_a_of_type_Bppo);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp, localDynamicTextItem.b(), 0, f1, f2);
    return;
    yqp.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bppp);
    this.jdField_a_of_type_Bpib.a(this.jdField_a_of_type_Bppp, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bppp parambppp)
  {
    boolean bool1 = this.jdField_a_of_type_Bppo.a(parambppp, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bppo.a(parambppp, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bppo.b(parambppp, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bpib != null) {
      this.jdField_a_of_type_Bpib.a(bool1, bool2, false, bool3, parambppp.l);
    }
    if (parambppp != null)
    {
      if (parambppp.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambppp.l, parambppp.r, parambppp.s, parambppp.t, parambppp.jdField_b_of_type_AndroidGraphicsPointF, parambppp.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambppp.l, parambppp.r, parambppp.s, parambppp.t, parambppp.jdField_b_of_type_AndroidGraphicsPointF, parambppp.m, 1);
  }
  
  private void e(bppp parambppp)
  {
    if ((parambppp == null) || (parambppp.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambppp instanceof bphx))
      {
        yqu.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambppp instanceof bpim));
    yqu.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bppp a()
  {
    return this.jdField_a_of_type_Bppp;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bppp);
    this.jdField_a_of_type_Bppp = null;
    this.jdField_a_of_type_Bppo.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bppp == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bppp.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bpib parambpib)
  {
    this.jdField_a_of_type_Bpib = parambpib;
  }
  
  public void a(bppp parambppp)
  {
    this.jdField_a_of_type_Bppp = parambppp;
    if (this.jdField_a_of_type_Bppp == null) {}
    do
    {
      return;
      bpic.c(true);
      if ((this.jdField_a_of_type_Bppp instanceof bpif))
      {
        this.jdField_a_of_type_Bppo.a(6.0F);
        this.jdField_a_of_type_Bppo.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bppp instanceof bphq)) || ((this.jdField_a_of_type_Bppp instanceof bphn)))
      {
        this.jdField_a_of_type_Bppo.a(18.0F);
        this.jdField_a_of_type_Bppo.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bppp instanceof bpim));
    this.jdField_a_of_type_Bppo.a(18.0F);
    this.jdField_a_of_type_Bppo.b(0.5F);
    ((bpim)this.jdField_a_of_type_Bppp).jdField_a_of_type_Bpwh.a((bpim)this.jdField_a_of_type_Bppp, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bppp parambppp)
  {
    if (parambppp == null) {}
    while ((parambppp.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambppp.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    yqp.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambppp.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bppp != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp, f1, f2, true))
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
    b(this.jdField_a_of_type_Bppp);
    this.jdField_a_of_type_Bppp = null;
    bpic.c(false);
    k();
  }
  
  public void c(bppp parambppp)
  {
    if (parambppp == null) {
      return;
    }
    parambppp.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bppp != null) {
      parambppp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bppp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambppp instanceof bphq)) && ((((bphq)parambppp).h == 1) || (((bphq)parambppp).h == 3))) {
      ((bphq)parambppp).a.setCallback(this);
    }
    this.jdField_a_of_type_Bppp = parambppp;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bpip != null) && (a(this.jdField_a_of_type_Bppp, paramMotionEvent))) {
      this.jdField_a_of_type_Bpip.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bppo.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bppp != null) {
        this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bppp);
      }
      if (this.jdField_a_of_type_Bppp != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bppp == null) || (this.jdField_a_of_type_Bppp.e != true) || (!this.jdField_a_of_type_Bppp.g) || (this.jdField_a_of_type_Bppp.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bppp.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      yqp.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bppp.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bppp != null)) {
        e(this.jdField_a_of_type_Bppp);
      }
      if (this.jdField_a_of_type_Bppp != null) {
        this.jdField_a_of_type_Bppp.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bppp != null) {
        this.jdField_a_of_type_Bppp.e = false;
      }
      this.jdField_a_of_type_Bppo.a();
      break label86;
      if (((this.jdField_a_of_type_Bppp instanceof bphq)) || ((this.jdField_a_of_type_Bppp instanceof bpif)))
      {
        d(this.jdField_a_of_type_Bppp);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bppp instanceof bpim));
    a((bpim)this.jdField_a_of_type_Bppp);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    k();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpia
 * JD-Core Version:    0.7.0.1
 */