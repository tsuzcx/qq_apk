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

public class bmqu
  extends bmri
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bmqv a;
  public bmyi a;
  public bmyj a;
  public boolean a;
  public bmyj b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmqu.class.getSimpleName();
  }
  
  public bmqu(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bmyi = new bmyi();
    this.jdField_a_of_type_Bmyi.a(true);
    this.jdField_a_of_type_Bmyi.a(6.0F);
    this.jdField_a_of_type_Bmyi.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, f1, f2)) {
      this.jdField_a_of_type_Bmyj.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bmyi.e(this.jdField_a_of_type_Bmyj, f1, f2))
      {
        this.jdField_a_of_type_Bmyj.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bmyi.b(this.jdField_a_of_type_Bmyj, f1, f2));
    this.jdField_a_of_type_Bmyj.jdField_k_of_type_Int = 2;
  }
  
  private void a(bmrg parambmrg)
  {
    if (parambmrg == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bmyi.a(parambmrg, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmyi.a(parambmrg, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmyi.b(parambmrg, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambmrg.e = parambmrg.w;
      parambmrg.jdField_a_of_type_AndroidGraphicsPointF = parambmrg.jdField_b_of_type_AndroidGraphicsPointF;
      parambmrg.jdField_a_of_type_Float = parambmrg.q;
      parambmrg.jdField_b_of_type_Float = parambmrg.r;
      parambmrg.c = parambmrg.s;
      parambmrg.d = parambmrg.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmrg.l, parambmrg.r, parambmrg.s, parambmrg.t, parambmrg.jdField_b_of_type_AndroidGraphicsPointF, parambmrg.m, 0);
      if (this.jdField_a_of_type_Bmqv == null) {
        break;
      }
      this.jdField_a_of_type_Bmqv.a(bool1, bool2, false, bool3, parambmrg.l);
      return;
      parambmrg.w = parambmrg.e;
      parambmrg.jdField_b_of_type_AndroidGraphicsPointF = parambmrg.jdField_a_of_type_AndroidGraphicsPointF;
      parambmrg.q = parambmrg.jdField_a_of_type_Float;
      parambmrg.r = parambmrg.jdField_b_of_type_Float;
      if (bool3)
      {
        parambmrg.t = parambmrg.d;
        if ((!bool1) && (!bool2)) {
          parambmrg.c = parambmrg.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambmrg.s = parambmrg.c;
        if (!bool3) {
          parambmrg.d = parambmrg.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bmyj parambmyj, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambmyj instanceof bmqr)) && (!(parambmyj instanceof bmrg))) || (!((bmrg)this.jdField_a_of_type_Bmyj).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bmyi.e(this.jdField_a_of_type_Bmyj, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bmyi.b(this.jdField_a_of_type_Bmyj, f1, f2)) {
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
    if (this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, f1, f2)) {
      if (this.jdField_a_of_type_Bmqv != null)
      {
        if (!(this.jdField_a_of_type_Bmyj instanceof bmqz)) {
          break label77;
        }
        paramMotionEvent = ((bmqz)this.jdField_a_of_type_Bmyj).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bmyi.e(this.jdField_a_of_type_Bmyj, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bmqv == null);
            this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj);
            return;
            if (!this.jdField_a_of_type_Bmyi.b(this.jdField_a_of_type_Bmyj, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bmqv == null);
          this.jdField_a_of_type_Bmqv.b(this.jdField_a_of_type_Bmyj);
          return;
          if (!this.jdField_a_of_type_Bmyi.c(this.jdField_a_of_type_Bmyj, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bmyj.g) {
            this.jdField_a_of_type_Bmyj.g = true;
          }
        } while (this.jdField_a_of_type_Bmqv == null);
        this.jdField_a_of_type_Bmqv.b(this.jdField_a_of_type_Bmyj, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, f1, f2, true)) || (this.jdField_a_of_type_Bmqv == null) || (this.jdField_a_of_type_Bmyj == null));
      if (!(this.jdField_a_of_type_Bmyj instanceof bmqz)) {
        break;
      }
      localDynamicTextItem = ((bmqz)this.jdField_a_of_type_Bmyj).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bmqz)this.jdField_a_of_type_Bmyj, this.jdField_a_of_type_Bmyi);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj, localDynamicTextItem.b(), 0, f1, f2);
    return;
    wxe.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bmyj);
    this.jdField_a_of_type_Bmqv.a(this.jdField_a_of_type_Bmyj, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bmyj parambmyj)
  {
    boolean bool1 = this.jdField_a_of_type_Bmyi.a(parambmyj, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmyi.a(parambmyj, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmyi.b(parambmyj, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bmqv != null) {
      this.jdField_a_of_type_Bmqv.a(bool1, bool2, false, bool3, parambmyj.l);
    }
    if (parambmyj != null)
    {
      if (parambmyj.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmyj.l, parambmyj.r, parambmyj.s, parambmyj.t, parambmyj.jdField_b_of_type_AndroidGraphicsPointF, parambmyj.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmyj.l, parambmyj.r, parambmyj.s, parambmyj.t, parambmyj.jdField_b_of_type_AndroidGraphicsPointF, parambmyj.m, 1);
  }
  
  private void e(bmyj parambmyj)
  {
    if ((parambmyj == null) || (parambmyj.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambmyj instanceof bmqr))
      {
        wxj.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambmyj instanceof bmrg));
    wxj.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bmyj a()
  {
    return this.jdField_a_of_type_Bmyj;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bmyj);
    this.jdField_a_of_type_Bmyj = null;
    this.jdField_a_of_type_Bmyi.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bmyj == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bmyj.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bmqv parambmqv)
  {
    this.jdField_a_of_type_Bmqv = parambmqv;
  }
  
  public void a(bmyj parambmyj)
  {
    this.jdField_a_of_type_Bmyj = parambmyj;
    if (this.jdField_a_of_type_Bmyj == null) {}
    do
    {
      return;
      bmqw.c(true);
      if ((this.jdField_a_of_type_Bmyj instanceof bmqz))
      {
        this.jdField_a_of_type_Bmyi.a(6.0F);
        this.jdField_a_of_type_Bmyi.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bmyj instanceof bmqk)) || ((this.jdField_a_of_type_Bmyj instanceof bmqh)))
      {
        this.jdField_a_of_type_Bmyi.a(18.0F);
        this.jdField_a_of_type_Bmyi.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bmyj instanceof bmrg));
    this.jdField_a_of_type_Bmyi.a(18.0F);
    this.jdField_a_of_type_Bmyi.b(0.5F);
    ((bmrg)this.jdField_a_of_type_Bmyj).jdField_a_of_type_Bnfb.a((bmrg)this.jdField_a_of_type_Bmyj, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bmyj parambmyj)
  {
    if (parambmyj == null) {}
    while ((parambmyj.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambmyj.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    wxe.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambmyj.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bmyj != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj, f1, f2, true))
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
    b(this.jdField_a_of_type_Bmyj);
    this.jdField_a_of_type_Bmyj = null;
    bmqw.c(false);
    k();
  }
  
  public void c(bmyj parambmyj)
  {
    if (parambmyj == null) {
      return;
    }
    parambmyj.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bmyj != null) {
      parambmyj.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bmyj.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambmyj instanceof bmqk)) && ((((bmqk)parambmyj).h == 1) || (((bmqk)parambmyj).h == 3))) {
      ((bmqk)parambmyj).a.setCallback(this);
    }
    this.jdField_a_of_type_Bmyj = parambmyj;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bmrj != null) && (a(this.jdField_a_of_type_Bmyj, paramMotionEvent))) {
      this.jdField_a_of_type_Bmrj.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bmyi.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bmyj != null) {
        this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmyj);
      }
      if (this.jdField_a_of_type_Bmyj != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bmyj == null) || (this.jdField_a_of_type_Bmyj.e != true) || (!this.jdField_a_of_type_Bmyj.g) || (this.jdField_a_of_type_Bmyj.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bmyj.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      wxe.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bmyj.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bmyj != null)) {
        e(this.jdField_a_of_type_Bmyj);
      }
      if (this.jdField_a_of_type_Bmyj != null) {
        this.jdField_a_of_type_Bmyj.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bmyj != null) {
        this.jdField_a_of_type_Bmyj.e = false;
      }
      this.jdField_a_of_type_Bmyi.a();
      break label86;
      if (((this.jdField_a_of_type_Bmyj instanceof bmqk)) || ((this.jdField_a_of_type_Bmyj instanceof bmqz)))
      {
        d(this.jdField_a_of_type_Bmyj);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bmyj instanceof bmrg));
    a((bmrg)this.jdField_a_of_type_Bmyj);
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
 * Qualified Name:     bmqu
 * JD-Core Version:    0.7.0.1
 */