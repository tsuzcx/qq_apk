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

public class bqjv
  extends bqkj
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bqjw a;
  public bqrj a;
  public bqrk a;
  public boolean a;
  public bqrk b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bqjv.class.getSimpleName();
  }
  
  public bqjv(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bqrj = new bqrj();
    this.jdField_a_of_type_Bqrj.a(true);
    this.jdField_a_of_type_Bqrj.a(6.0F);
    this.jdField_a_of_type_Bqrj.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, f1, f2)) {
      this.jdField_a_of_type_Bqrk.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bqrj.e(this.jdField_a_of_type_Bqrk, f1, f2))
      {
        this.jdField_a_of_type_Bqrk.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bqrj.b(this.jdField_a_of_type_Bqrk, f1, f2));
    this.jdField_a_of_type_Bqrk.jdField_k_of_type_Int = 2;
  }
  
  private void a(bqkh parambqkh)
  {
    if (parambqkh == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bqrj.a(parambqkh, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bqrj.a(parambqkh, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bqrj.b(parambqkh, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambqkh.e = parambqkh.w;
      parambqkh.jdField_a_of_type_AndroidGraphicsPointF = parambqkh.jdField_b_of_type_AndroidGraphicsPointF;
      parambqkh.jdField_a_of_type_Float = parambqkh.q;
      parambqkh.jdField_b_of_type_Float = parambqkh.r;
      parambqkh.c = parambqkh.s;
      parambqkh.d = parambqkh.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambqkh.l, parambqkh.r, parambqkh.s, parambqkh.t, parambqkh.jdField_b_of_type_AndroidGraphicsPointF, parambqkh.m, 0);
      if (this.jdField_a_of_type_Bqjw == null) {
        break;
      }
      this.jdField_a_of_type_Bqjw.a(bool1, bool2, false, bool3, parambqkh.l);
      return;
      parambqkh.w = parambqkh.e;
      parambqkh.jdField_b_of_type_AndroidGraphicsPointF = parambqkh.jdField_a_of_type_AndroidGraphicsPointF;
      parambqkh.q = parambqkh.jdField_a_of_type_Float;
      parambqkh.r = parambqkh.jdField_b_of_type_Float;
      if (bool3)
      {
        parambqkh.t = parambqkh.d;
        if ((!bool1) && (!bool2)) {
          parambqkh.c = parambqkh.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambqkh.s = parambqkh.c;
        if (!bool3) {
          parambqkh.d = parambqkh.t;
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, paramFloat1, paramFloat2, true);
  }
  
  private boolean a(bqrk parambqrk, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parambqrk instanceof bqjs)) && (!(parambqrk instanceof bqkh))) || (!((bqkh)this.jdField_a_of_type_Bqrk).jdField_b_of_type_Boolean));
    boolean bool1;
    if (!this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Bqrj.e(this.jdField_a_of_type_Bqrk, f1, f2)) {
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
      if (!this.jdField_a_of_type_Bqrj.b(this.jdField_a_of_type_Bqrk, f1, f2)) {
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
    if (this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, f1, f2)) {
      if (this.jdField_a_of_type_Bqjw != null)
      {
        if (!(this.jdField_a_of_type_Bqrk instanceof bqka)) {
          break label77;
        }
        paramMotionEvent = ((bqka)this.jdField_a_of_type_Bqrk).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bqrj.e(this.jdField_a_of_type_Bqrk, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bqjw == null);
            this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk);
            return;
            if (!this.jdField_a_of_type_Bqrj.b(this.jdField_a_of_type_Bqrk, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bqjw == null);
          this.jdField_a_of_type_Bqjw.b(this.jdField_a_of_type_Bqrk);
          return;
          if (!this.jdField_a_of_type_Bqrj.c(this.jdField_a_of_type_Bqrk, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bqrk.g) {
            this.jdField_a_of_type_Bqrk.g = true;
          }
        } while (this.jdField_a_of_type_Bqjw == null);
        this.jdField_a_of_type_Bqjw.b(this.jdField_a_of_type_Bqrk, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, f1, f2, true)) || (this.jdField_a_of_type_Bqjw == null) || (this.jdField_a_of_type_Bqrk == null));
      if (!(this.jdField_a_of_type_Bqrk instanceof bqka)) {
        break;
      }
      localDynamicTextItem = ((bqka)this.jdField_a_of_type_Bqrk).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bqka)this.jdField_a_of_type_Bqrk, this.jdField_a_of_type_Bqrj);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk, localDynamicTextItem.b(), 0, f1, f2);
    return;
    yuk.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bqrk);
    this.jdField_a_of_type_Bqjw.a(this.jdField_a_of_type_Bqrk, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bqrk parambqrk)
  {
    boolean bool1 = this.jdField_a_of_type_Bqrj.a(parambqrk, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bqrj.a(parambqrk, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bqrj.b(parambqrk, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bqjw != null) {
      this.jdField_a_of_type_Bqjw.a(bool1, bool2, false, bool3, parambqrk.l);
    }
    if (parambqrk != null)
    {
      if (parambqrk.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambqrk.l, parambqrk.r, parambqrk.s, parambqrk.t, parambqrk.jdField_b_of_type_AndroidGraphicsPointF, parambqrk.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambqrk.l, parambqrk.r, parambqrk.s, parambqrk.t, parambqrk.jdField_b_of_type_AndroidGraphicsPointF, parambqrk.m, 1);
  }
  
  private void e(bqrk parambqrk)
  {
    if ((parambqrk == null) || (parambqrk.jdField_k_of_type_Int != 2)) {}
    do
    {
      return;
      if ((parambqrk instanceof bqjs))
      {
        yup.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parambqrk instanceof bqkh));
    yup.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  public bqrk a()
  {
    return this.jdField_a_of_type_Bqrk;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bqrk);
    this.jdField_a_of_type_Bqrk = null;
    this.jdField_a_of_type_Bqrj.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bqrk == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bqrk.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bqjw parambqjw)
  {
    this.jdField_a_of_type_Bqjw = parambqjw;
  }
  
  public void a(bqrk parambqrk)
  {
    this.jdField_a_of_type_Bqrk = parambqrk;
    if (this.jdField_a_of_type_Bqrk == null) {}
    do
    {
      return;
      bqjx.c(true);
      if ((this.jdField_a_of_type_Bqrk instanceof bqka))
      {
        this.jdField_a_of_type_Bqrj.a(6.0F);
        this.jdField_a_of_type_Bqrj.b(0.2F);
        return;
      }
      if (((this.jdField_a_of_type_Bqrk instanceof bqjl)) || ((this.jdField_a_of_type_Bqrk instanceof bqji)))
      {
        this.jdField_a_of_type_Bqrj.a(18.0F);
        this.jdField_a_of_type_Bqrj.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Bqrk instanceof bqkh));
    this.jdField_a_of_type_Bqrj.a(18.0F);
    this.jdField_a_of_type_Bqrj.b(0.5F);
    ((bqkh)this.jdField_a_of_type_Bqrk).jdField_a_of_type_Bqyc.a((bqkh)this.jdField_a_of_type_Bqrk, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
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
  
  public void b(bqrk parambqrk)
  {
    if (parambqrk == null) {}
    while ((parambqrk.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambqrk.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    yuk.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambqrk.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bqrk != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk, f1, f2, true))
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
    b(this.jdField_a_of_type_Bqrk);
    this.jdField_a_of_type_Bqrk = null;
    bqjx.c(false);
    k();
  }
  
  public void c(bqrk parambqrk)
  {
    if (parambqrk == null) {
      return;
    }
    parambqrk.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bqrk != null) {
      parambqrk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bqrk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambqrk instanceof bqjl)) && ((((bqjl)parambqrk).h == 1) || (((bqjl)parambqrk).h == 3))) {
      ((bqjl)parambqrk).a.setCallback(this);
    }
    this.jdField_a_of_type_Bqrk = parambqrk;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Bqkk != null) && (a(this.jdField_a_of_type_Bqrk, paramMotionEvent))) {
      this.jdField_a_of_type_Bqkk.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Bqrj.a(paramMotionEvent, true);
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
      if (this.jdField_a_of_type_Bqrk != null) {
        this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqrk);
      }
      if (this.jdField_a_of_type_Bqrk != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bqrk == null) || (this.jdField_a_of_type_Bqrk.e != true) || (!this.jdField_a_of_type_Bqrk.g) || (this.jdField_a_of_type_Bqrk.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bqrk.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      yuk.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bqrk.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bqrk != null)) {
        e(this.jdField_a_of_type_Bqrk);
      }
      if (this.jdField_a_of_type_Bqrk != null) {
        this.jdField_a_of_type_Bqrk.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bqrk != null) {
        this.jdField_a_of_type_Bqrk.e = false;
      }
      this.jdField_a_of_type_Bqrj.a();
      break label86;
      if (((this.jdField_a_of_type_Bqrk instanceof bqjl)) || ((this.jdField_a_of_type_Bqrk instanceof bqka)))
      {
        d(this.jdField_a_of_type_Bqrk);
        return true;
      }
    } while (!(this.jdField_a_of_type_Bqrk instanceof bqkh));
    a((bqkh)this.jdField_a_of_type_Bqrk);
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
 * Qualified Name:     bqjv
 * JD-Core Version:    0.7.0.1
 */