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

public class bmmi
  extends bmmw
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bmmj a;
  public bmtw a;
  public bmtx a;
  public boolean a;
  public bmtx b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmmi.class.getSimpleName();
  }
  
  public bmmi(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bmtw = new bmtw();
    this.jdField_a_of_type_Bmtw.a(true);
    this.jdField_a_of_type_Bmtw.a(6.0F);
    this.jdField_a_of_type_Bmtw.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, f1, f2)) {
      this.jdField_a_of_type_Bmtx.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bmtw.e(this.jdField_a_of_type_Bmtx, f1, f2))
      {
        this.jdField_a_of_type_Bmtx.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bmtw.b(this.jdField_a_of_type_Bmtx, f1, f2));
    this.jdField_a_of_type_Bmtx.jdField_k_of_type_Int = 2;
  }
  
  private void a(bmmu parambmmu)
  {
    if (parambmmu == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bmtw.a(parambmmu, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmtw.a(parambmmu, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmtw.b(parambmmu, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambmmu.e = parambmmu.w;
      parambmmu.jdField_a_of_type_AndroidGraphicsPointF = parambmmu.jdField_b_of_type_AndroidGraphicsPointF;
      parambmmu.jdField_a_of_type_Float = parambmmu.q;
      parambmmu.jdField_b_of_type_Float = parambmmu.r;
      parambmmu.c = parambmmu.s;
      parambmmu.d = parambmmu.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmmu.l, parambmmu.r, parambmmu.s, parambmmu.t, parambmmu.jdField_b_of_type_AndroidGraphicsPointF, parambmmu.m, 0);
      if (this.jdField_a_of_type_Bmmj == null) {
        break;
      }
      this.jdField_a_of_type_Bmmj.a(bool1, bool2, false, bool3, parambmmu.l);
      return;
      parambmmu.w = parambmmu.e;
      parambmmu.jdField_b_of_type_AndroidGraphicsPointF = parambmmu.jdField_a_of_type_AndroidGraphicsPointF;
      parambmmu.q = parambmmu.jdField_a_of_type_Float;
      parambmmu.r = parambmmu.jdField_b_of_type_Float;
      if (bool3)
      {
        parambmmu.t = parambmmu.d;
        if ((!bool1) && (!bool2)) {
          parambmmu.c = parambmmu.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambmmu.s = parambmmu.c;
        if (!bool3) {
          parambmmu.d = parambmmu.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bmtx parambmtx, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambmtx instanceof bmmf)) && (!(parambmtx instanceof bmmu))) || (!((bmmu)this.jdField_a_of_type_Bmtx).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bmtw.e(this.jdField_a_of_type_Bmtx, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bmtw.b(this.jdField_a_of_type_Bmtx, f1, f2)) {
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
    if (this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, f1, f2)) {
      if (this.jdField_a_of_type_Bmmj != null)
      {
        if (!(this.jdField_a_of_type_Bmtx instanceof bmmn)) {
          break label77;
        }
        paramMotionEvent = ((bmmn)this.jdField_a_of_type_Bmtx).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bmtw.e(this.jdField_a_of_type_Bmtx, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bmmj == null);
            this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx);
            return;
            if (!this.jdField_a_of_type_Bmtw.b(this.jdField_a_of_type_Bmtx, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bmmj == null);
          this.jdField_a_of_type_Bmmj.b(this.jdField_a_of_type_Bmtx);
          return;
          if (!this.jdField_a_of_type_Bmtw.c(this.jdField_a_of_type_Bmtx, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bmtx.g) {
            this.jdField_a_of_type_Bmtx.g = true;
          }
        } while (this.jdField_a_of_type_Bmmj == null);
        this.jdField_a_of_type_Bmmj.b(this.jdField_a_of_type_Bmtx, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, f1, f2, true)) || (this.jdField_a_of_type_Bmmj == null) || (this.jdField_a_of_type_Bmtx == null));
      if (!(this.jdField_a_of_type_Bmtx instanceof bmmn)) {
        break;
      }
      localDynamicTextItem = ((bmmn)this.jdField_a_of_type_Bmtx).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bmmn)this.jdField_a_of_type_Bmtx, this.jdField_a_of_type_Bmtw);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx, localDynamicTextItem.b(), 0, f1, f2);
    return;
    wsv.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bmtx);
    this.jdField_a_of_type_Bmmj.a(this.jdField_a_of_type_Bmtx, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bmtx parambmtx)
  {
    boolean bool1 = this.jdField_a_of_type_Bmtw.a(parambmtx, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmtw.a(parambmtx, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmtw.b(parambmtx, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bmmj != null) {
      this.jdField_a_of_type_Bmmj.a(bool1, bool2, false, bool3, parambmtx.l);
    }
    if (parambmtx != null)
    {
      if (parambmtx.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmtx.l, parambmtx.r, parambmtx.s, parambmtx.t, parambmtx.jdField_b_of_type_AndroidGraphicsPointF, parambmtx.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmtx.l, parambmtx.r, parambmtx.s, parambmtx.t, parambmtx.jdField_b_of_type_AndroidGraphicsPointF, parambmtx.m, 1);
  }
  
  private void e(bmtx parambmtx)
  {
    if ((parambmtx == null) || (parambmtx.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambmtx instanceof bmmf))
      {
        wta.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambmtx instanceof bmmu));
    wta.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bmtx a()
  {
    return this.jdField_a_of_type_Bmtx;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bmtx);
    this.jdField_a_of_type_Bmtx = null;
    this.jdField_a_of_type_Bmtw.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bmtx == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bmtx.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bmmj parambmmj)
  {
    this.jdField_a_of_type_Bmmj = parambmmj;
  }
  
  public void a(bmtx parambmtx)
  {
    this.jdField_a_of_type_Bmtx = parambmtx;
    if (this.jdField_a_of_type_Bmtx == null) {}
    do
    {
      return;
      bmmk.c(true);
      if ((this.jdField_a_of_type_Bmtx instanceof bmmn))
      {
        this.jdField_a_of_type_Bmtw.a(6.0F);
        this.jdField_a_of_type_Bmtw.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bmtx instanceof bmly)) || ((this.jdField_a_of_type_Bmtx instanceof bmlv)))
      {
        this.jdField_a_of_type_Bmtw.a(18.0F);
        this.jdField_a_of_type_Bmtw.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bmtx instanceof bmmu));
    this.jdField_a_of_type_Bmtw.a(18.0F);
    this.jdField_a_of_type_Bmtw.b(0.5F);
    ((bmmu)this.jdField_a_of_type_Bmtx).jdField_a_of_type_Bnap.a((bmmu)this.jdField_a_of_type_Bmtx, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bmtx parambmtx)
  {
    if (parambmtx == null) {}
    while ((parambmtx.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambmtx.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    wsv.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambmtx.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bmtx != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx, f1, f2, true))
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
    b(this.jdField_a_of_type_Bmtx);
    this.jdField_a_of_type_Bmtx = null;
    bmmk.c(false);
    k();
  }
  
  public void c(bmtx parambmtx)
  {
    if (parambmtx == null) {
      return;
    }
    parambmtx.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bmtx != null) {
      parambmtx.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bmtx.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambmtx instanceof bmly)) && ((((bmly)parambmtx).h == 1) || (((bmly)parambmtx).h == 3))) {
      ((bmly)parambmtx).a.setCallback(this);
    }
    this.jdField_a_of_type_Bmtx = parambmtx;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bmmx != null) && (a(this.jdField_a_of_type_Bmtx, paramMotionEvent))) {
      this.jdField_a_of_type_Bmmx.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bmtw.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bmtx != null) {
        this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmtx);
      }
      if (this.jdField_a_of_type_Bmtx != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bmtx == null) || (this.jdField_a_of_type_Bmtx.e != true) || (!this.jdField_a_of_type_Bmtx.g) || (this.jdField_a_of_type_Bmtx.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bmtx.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      wsv.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bmtx.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bmtx != null)) {
        e(this.jdField_a_of_type_Bmtx);
      }
      if (this.jdField_a_of_type_Bmtx != null) {
        this.jdField_a_of_type_Bmtx.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bmtx != null) {
        this.jdField_a_of_type_Bmtx.e = false;
      }
      this.jdField_a_of_type_Bmtw.a();
      break label86;
      if (((this.jdField_a_of_type_Bmtx instanceof bmly)) || ((this.jdField_a_of_type_Bmtx instanceof bmmn)))
      {
        d(this.jdField_a_of_type_Bmtx);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bmtx instanceof bmmu));
    a((bmmu)this.jdField_a_of_type_Bmtx);
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
 * Qualified Name:     bmmi
 * JD-Core Version:    0.7.0.1
 */