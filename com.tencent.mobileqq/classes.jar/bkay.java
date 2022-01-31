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

public class bkay
  extends bkbm
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bkaz a;
  public bkim a;
  public bkin a;
  public boolean a;
  public bkin b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bkay.class.getSimpleName();
  }
  
  public bkay(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bkim = new bkim();
    this.jdField_a_of_type_Bkim.a(true);
    this.jdField_a_of_type_Bkim.a(6.0F);
    this.jdField_a_of_type_Bkim.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, f1, f2)) {
      this.jdField_a_of_type_Bkin.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bkim.e(this.jdField_a_of_type_Bkin, f1, f2))
      {
        this.jdField_a_of_type_Bkin.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bkim.b(this.jdField_a_of_type_Bkin, f1, f2));
    this.jdField_a_of_type_Bkin.jdField_k_of_type_Int = 2;
  }
  
  private void a(bkbk parambkbk)
  {
    if (parambkbk == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bkim.a(parambkbk, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bkim.a(parambkbk, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bkim.b(parambkbk, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambkbk.e = parambkbk.w;
      parambkbk.jdField_a_of_type_AndroidGraphicsPointF = parambkbk.jdField_b_of_type_AndroidGraphicsPointF;
      parambkbk.jdField_a_of_type_Float = parambkbk.q;
      parambkbk.jdField_b_of_type_Float = parambkbk.r;
      parambkbk.c = parambkbk.s;
      parambkbk.d = parambkbk.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkbk.l, parambkbk.r, parambkbk.s, parambkbk.t, parambkbk.jdField_b_of_type_AndroidGraphicsPointF, parambkbk.m, 0);
      if (this.jdField_a_of_type_Bkaz == null) {
        break;
      }
      this.jdField_a_of_type_Bkaz.a(bool1, bool2, false, bool3, parambkbk.l);
      return;
      parambkbk.w = parambkbk.e;
      parambkbk.jdField_b_of_type_AndroidGraphicsPointF = parambkbk.jdField_a_of_type_AndroidGraphicsPointF;
      parambkbk.q = parambkbk.jdField_a_of_type_Float;
      parambkbk.r = parambkbk.jdField_b_of_type_Float;
      if (bool3)
      {
        parambkbk.t = parambkbk.d;
        if ((!bool1) && (!bool2)) {
          parambkbk.c = parambkbk.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambkbk.s = parambkbk.c;
        if (!bool3) {
          parambkbk.d = parambkbk.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bkin parambkin, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambkin instanceof bkav)) && (!(parambkin instanceof bkbk))) || (!((bkbk)this.jdField_a_of_type_Bkin).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bkim.e(this.jdField_a_of_type_Bkin, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bkim.b(this.jdField_a_of_type_Bkin, f1, f2)) {
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
    if (this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, f1, f2)) {
      if (this.jdField_a_of_type_Bkaz != null)
      {
        if (!(this.jdField_a_of_type_Bkin instanceof bkbd)) {
          break label77;
        }
        paramMotionEvent = ((bkbd)this.jdField_a_of_type_Bkin).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bkim.e(this.jdField_a_of_type_Bkin, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bkaz == null);
            this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin);
            return;
            if (!this.jdField_a_of_type_Bkim.b(this.jdField_a_of_type_Bkin, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bkaz == null);
          this.jdField_a_of_type_Bkaz.b(this.jdField_a_of_type_Bkin);
          return;
          if (!this.jdField_a_of_type_Bkim.c(this.jdField_a_of_type_Bkin, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bkin.g) {
            this.jdField_a_of_type_Bkin.g = true;
          }
        } while (this.jdField_a_of_type_Bkaz == null);
        this.jdField_a_of_type_Bkaz.b(this.jdField_a_of_type_Bkin, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, f1, f2, true)) || (this.jdField_a_of_type_Bkaz == null) || (this.jdField_a_of_type_Bkin == null));
      if (!(this.jdField_a_of_type_Bkin instanceof bkbd)) {
        break;
      }
      localDynamicTextItem = ((bkbd)this.jdField_a_of_type_Bkin).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bkbd)this.jdField_a_of_type_Bkin, this.jdField_a_of_type_Bkim);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin, localDynamicTextItem.b(), 0, f1, f2);
    return;
    ved.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bkin);
    this.jdField_a_of_type_Bkaz.a(this.jdField_a_of_type_Bkin, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bkin parambkin)
  {
    boolean bool1 = this.jdField_a_of_type_Bkim.a(parambkin, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bkim.a(parambkin, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bkim.b(parambkin, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bkaz != null) {
      this.jdField_a_of_type_Bkaz.a(bool1, bool2, false, bool3, parambkin.l);
    }
    if (parambkin != null)
    {
      if (parambkin.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkin.l, parambkin.r, parambkin.s, parambkin.t, parambkin.jdField_b_of_type_AndroidGraphicsPointF, parambkin.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkin.l, parambkin.r, parambkin.s, parambkin.t, parambkin.jdField_b_of_type_AndroidGraphicsPointF, parambkin.m, 1);
  }
  
  private void e(bkin parambkin)
  {
    if ((parambkin == null) || (parambkin.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambkin instanceof bkav))
      {
        vei.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambkin instanceof bkbk));
    vei.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bkin a()
  {
    return this.jdField_a_of_type_Bkin;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bkin);
    this.jdField_a_of_type_Bkin = null;
    this.jdField_a_of_type_Bkim.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bkin == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bkin.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bkaz parambkaz)
  {
    this.jdField_a_of_type_Bkaz = parambkaz;
  }
  
  public void a(bkin parambkin)
  {
    this.jdField_a_of_type_Bkin = parambkin;
    if (this.jdField_a_of_type_Bkin == null) {}
    do
    {
      return;
      bkba.c(true);
      if ((this.jdField_a_of_type_Bkin instanceof bkbd))
      {
        this.jdField_a_of_type_Bkim.a(6.0F);
        this.jdField_a_of_type_Bkim.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bkin instanceof bkao)) || ((this.jdField_a_of_type_Bkin instanceof bkal)))
      {
        this.jdField_a_of_type_Bkim.a(18.0F);
        this.jdField_a_of_type_Bkim.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bkin instanceof bkbk));
    this.jdField_a_of_type_Bkim.a(18.0F);
    this.jdField_a_of_type_Bkim.b(0.5F);
    ((bkbk)this.jdField_a_of_type_Bkin).jdField_a_of_type_Bkpf.a((bkbk)this.jdField_a_of_type_Bkin, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bkin parambkin)
  {
    if (parambkin == null) {}
    while ((parambkin.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambkin.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    ved.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambkin.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bkin != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin, f1, f2, true))
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
    b(this.jdField_a_of_type_Bkin);
    this.jdField_a_of_type_Bkin = null;
    bkba.c(false);
    k();
  }
  
  public void c(bkin parambkin)
  {
    if (parambkin == null) {
      return;
    }
    parambkin.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bkin != null) {
      parambkin.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bkin.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambkin instanceof bkao)) && ((((bkao)parambkin).h == 1) || (((bkao)parambkin).h == 3))) {
      ((bkao)parambkin).a.setCallback(this);
    }
    this.jdField_a_of_type_Bkin = parambkin;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bkbn != null) && (a(this.jdField_a_of_type_Bkin, paramMotionEvent))) {
      this.jdField_a_of_type_Bkbn.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bkim.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bkin != null) {
        this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkin);
      }
      if (this.jdField_a_of_type_Bkin != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bkin == null) || (this.jdField_a_of_type_Bkin.e != true) || (!this.jdField_a_of_type_Bkin.g) || (this.jdField_a_of_type_Bkin.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bkin.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      ved.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bkin.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkin != null)) {
        e(this.jdField_a_of_type_Bkin);
      }
      if (this.jdField_a_of_type_Bkin != null) {
        this.jdField_a_of_type_Bkin.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bkin != null) {
        this.jdField_a_of_type_Bkin.e = false;
      }
      this.jdField_a_of_type_Bkim.a();
      break label86;
      if (((this.jdField_a_of_type_Bkin instanceof bkao)) || ((this.jdField_a_of_type_Bkin instanceof bkbd)))
      {
        d(this.jdField_a_of_type_Bkin);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bkin instanceof bkbk));
    a((bkbk)this.jdField_a_of_type_Bkin);
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
 * Qualified Name:     bkay
 * JD-Core Version:    0.7.0.1
 */