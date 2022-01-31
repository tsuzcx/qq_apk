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

public class bkah
  extends bkav
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bkai a;
  public bkhv a;
  public bkhw a;
  public boolean a;
  public bkhw b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bkah.class.getSimpleName();
  }
  
  public bkah(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bkhv = new bkhv();
    this.jdField_a_of_type_Bkhv.a(true);
    this.jdField_a_of_type_Bkhv.a(6.0F);
    this.jdField_a_of_type_Bkhv.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, f1, f2)) {
      this.jdField_a_of_type_Bkhw.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bkhv.e(this.jdField_a_of_type_Bkhw, f1, f2))
      {
        this.jdField_a_of_type_Bkhw.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bkhv.b(this.jdField_a_of_type_Bkhw, f1, f2));
    this.jdField_a_of_type_Bkhw.jdField_k_of_type_Int = 2;
  }
  
  private void a(bkat parambkat)
  {
    if (parambkat == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bkhv.a(parambkat, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bkhv.a(parambkat, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bkhv.b(parambkat, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambkat.e = parambkat.w;
      parambkat.jdField_a_of_type_AndroidGraphicsPointF = parambkat.jdField_b_of_type_AndroidGraphicsPointF;
      parambkat.jdField_a_of_type_Float = parambkat.q;
      parambkat.jdField_b_of_type_Float = parambkat.r;
      parambkat.c = parambkat.s;
      parambkat.d = parambkat.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkat.l, parambkat.r, parambkat.s, parambkat.t, parambkat.jdField_b_of_type_AndroidGraphicsPointF, parambkat.m, 0);
      if (this.jdField_a_of_type_Bkai == null) {
        break;
      }
      this.jdField_a_of_type_Bkai.a(bool1, bool2, false, bool3, parambkat.l);
      return;
      parambkat.w = parambkat.e;
      parambkat.jdField_b_of_type_AndroidGraphicsPointF = parambkat.jdField_a_of_type_AndroidGraphicsPointF;
      parambkat.q = parambkat.jdField_a_of_type_Float;
      parambkat.r = parambkat.jdField_b_of_type_Float;
      if (bool3)
      {
        parambkat.t = parambkat.d;
        if ((!bool1) && (!bool2)) {
          parambkat.c = parambkat.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambkat.s = parambkat.c;
        if (!bool3) {
          parambkat.d = parambkat.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bkhw parambkhw, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambkhw instanceof bkae)) && (!(parambkhw instanceof bkat))) || (!((bkat)this.jdField_a_of_type_Bkhw).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bkhv.e(this.jdField_a_of_type_Bkhw, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bkhv.b(this.jdField_a_of_type_Bkhw, f1, f2)) {
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
    if (this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, f1, f2)) {
      if (this.jdField_a_of_type_Bkai != null)
      {
        if (!(this.jdField_a_of_type_Bkhw instanceof bkam)) {
          break label77;
        }
        paramMotionEvent = ((bkam)this.jdField_a_of_type_Bkhw).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bkhv.e(this.jdField_a_of_type_Bkhw, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bkai == null);
            this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw);
            return;
            if (!this.jdField_a_of_type_Bkhv.b(this.jdField_a_of_type_Bkhw, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bkai == null);
          this.jdField_a_of_type_Bkai.b(this.jdField_a_of_type_Bkhw);
          return;
          if (!this.jdField_a_of_type_Bkhv.c(this.jdField_a_of_type_Bkhw, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bkhw.g) {
            this.jdField_a_of_type_Bkhw.g = true;
          }
        } while (this.jdField_a_of_type_Bkai == null);
        this.jdField_a_of_type_Bkai.b(this.jdField_a_of_type_Bkhw, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, f1, f2, true)) || (this.jdField_a_of_type_Bkai == null) || (this.jdField_a_of_type_Bkhw == null));
      if (!(this.jdField_a_of_type_Bkhw instanceof bkam)) {
        break;
      }
      localDynamicTextItem = ((bkam)this.jdField_a_of_type_Bkhw).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bkam)this.jdField_a_of_type_Bkhw, this.jdField_a_of_type_Bkhv);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw, localDynamicTextItem.b(), 0, f1, f2);
    return;
    veg.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bkhw);
    this.jdField_a_of_type_Bkai.a(this.jdField_a_of_type_Bkhw, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bkhw parambkhw)
  {
    boolean bool1 = this.jdField_a_of_type_Bkhv.a(parambkhw, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bkhv.a(parambkhw, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bkhv.b(parambkhw, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bkai != null) {
      this.jdField_a_of_type_Bkai.a(bool1, bool2, false, bool3, parambkhw.l);
    }
    if (parambkhw != null)
    {
      if (parambkhw.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkhw.l, parambkhw.r, parambkhw.s, parambkhw.t, parambkhw.jdField_b_of_type_AndroidGraphicsPointF, parambkhw.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkhw.l, parambkhw.r, parambkhw.s, parambkhw.t, parambkhw.jdField_b_of_type_AndroidGraphicsPointF, parambkhw.m, 1);
  }
  
  private void e(bkhw parambkhw)
  {
    if ((parambkhw == null) || (parambkhw.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambkhw instanceof bkae))
      {
        vel.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambkhw instanceof bkat));
    vel.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bkhw a()
  {
    return this.jdField_a_of_type_Bkhw;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bkhw);
    this.jdField_a_of_type_Bkhw = null;
    this.jdField_a_of_type_Bkhv.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bkhw == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bkhw.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bkai parambkai)
  {
    this.jdField_a_of_type_Bkai = parambkai;
  }
  
  public void a(bkhw parambkhw)
  {
    this.jdField_a_of_type_Bkhw = parambkhw;
    if (this.jdField_a_of_type_Bkhw == null) {}
    do
    {
      return;
      bkaj.c(true);
      if ((this.jdField_a_of_type_Bkhw instanceof bkam))
      {
        this.jdField_a_of_type_Bkhv.a(6.0F);
        this.jdField_a_of_type_Bkhv.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bkhw instanceof bjzx)) || ((this.jdField_a_of_type_Bkhw instanceof bjzu)))
      {
        this.jdField_a_of_type_Bkhv.a(18.0F);
        this.jdField_a_of_type_Bkhv.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bkhw instanceof bkat));
    this.jdField_a_of_type_Bkhv.a(18.0F);
    this.jdField_a_of_type_Bkhv.b(0.5F);
    ((bkat)this.jdField_a_of_type_Bkhw).jdField_a_of_type_Bkoo.a((bkat)this.jdField_a_of_type_Bkhw, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bkhw parambkhw)
  {
    if (parambkhw == null) {}
    while ((parambkhw.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambkhw.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    veg.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambkhw.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bkhw != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw, f1, f2, true))
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
    b(this.jdField_a_of_type_Bkhw);
    this.jdField_a_of_type_Bkhw = null;
    bkaj.c(false);
    k();
  }
  
  public void c(bkhw parambkhw)
  {
    if (parambkhw == null) {
      return;
    }
    parambkhw.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bkhw != null) {
      parambkhw.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bkhw.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambkhw instanceof bjzx)) && ((((bjzx)parambkhw).h == 1) || (((bjzx)parambkhw).h == 3))) {
      ((bjzx)parambkhw).a.setCallback(this);
    }
    this.jdField_a_of_type_Bkhw = parambkhw;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bkaw != null) && (a(this.jdField_a_of_type_Bkhw, paramMotionEvent))) {
      this.jdField_a_of_type_Bkaw.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bkhv.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bkhw != null) {
        this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bkhw);
      }
      if (this.jdField_a_of_type_Bkhw != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bkhw == null) || (this.jdField_a_of_type_Bkhw.e != true) || (!this.jdField_a_of_type_Bkhw.g) || (this.jdField_a_of_type_Bkhw.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bkhw.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      veg.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bkhw.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkhw != null)) {
        e(this.jdField_a_of_type_Bkhw);
      }
      if (this.jdField_a_of_type_Bkhw != null) {
        this.jdField_a_of_type_Bkhw.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bkhw != null) {
        this.jdField_a_of_type_Bkhw.e = false;
      }
      this.jdField_a_of_type_Bkhv.a();
      break label86;
      if (((this.jdField_a_of_type_Bkhw instanceof bjzx)) || ((this.jdField_a_of_type_Bkhw instanceof bkam)))
      {
        d(this.jdField_a_of_type_Bkhw);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bkhw instanceof bkat));
    a((bkat)this.jdField_a_of_type_Bkhw);
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
 * Qualified Name:     bkah
 * JD-Core Version:    0.7.0.1
 */