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

public class bngl
  extends bngv
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bngm a;
  public bnnn a;
  public bnno a;
  public boolean a;
  public bnno b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bngl.class.getSimpleName();
  }
  
  public bngl(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bnnn = new bnnn();
    this.jdField_a_of_type_Bnnn.a(true);
    this.jdField_a_of_type_Bnnn.a(6.0F);
    this.jdField_a_of_type_Bnnn.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno, f1, f2)) {
      this.jdField_a_of_type_Bnno.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bnnn.e(this.jdField_a_of_type_Bnno, f1, f2))
      {
        this.jdField_a_of_type_Bnno.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bnnn.b(this.jdField_a_of_type_Bnno, f1, f2));
    this.jdField_a_of_type_Bnno.jdField_k_of_type_Int = 2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno, paramFloat1, paramFloat2, true);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno, f1, f2)) {
      if (this.jdField_a_of_type_Bngm != null)
      {
        if (!(this.jdField_a_of_type_Bnno instanceof bngq)) {
          break label77;
        }
        paramMotionEvent = ((bngq)this.jdField_a_of_type_Bnno).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bnnn.e(this.jdField_a_of_type_Bnno, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bngm == null);
            this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno);
            return;
            if (!this.jdField_a_of_type_Bnnn.b(this.jdField_a_of_type_Bnno, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bngm == null);
          this.jdField_a_of_type_Bngm.b(this.jdField_a_of_type_Bnno);
          return;
          if (!this.jdField_a_of_type_Bnnn.c(this.jdField_a_of_type_Bnno, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bnno.g) {
            this.jdField_a_of_type_Bnno.g = true;
          }
        } while (this.jdField_a_of_type_Bngm == null);
        this.jdField_a_of_type_Bngm.b(this.jdField_a_of_type_Bnno, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno, f1, f2, true)) || (this.jdField_a_of_type_Bngm == null) || (this.jdField_a_of_type_Bnno == null));
      if (!(this.jdField_a_of_type_Bnno instanceof bngq)) {
        break;
      }
      localDynamicTextItem = ((bngq)this.jdField_a_of_type_Bnno).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bngq)this.jdField_a_of_type_Bnno, this.jdField_a_of_type_Bnnn);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno, localDynamicTextItem.b(), 0, f1, f2);
    return;
    xvv.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bnno);
    this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bnno, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bnno parambnno)
  {
    boolean bool1 = this.jdField_a_of_type_Bnnn.a(parambnno, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bnnn.a(parambnno, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bnnn.b(parambnno, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.a(bool1, bool2, false, bool3, parambnno.l);
    }
    if (parambnno != null)
    {
      if (parambnno.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambnno.l, parambnno.r, parambnno.s, parambnno.t, parambnno.jdField_a_of_type_AndroidGraphicsPointF, parambnno.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambnno.l, parambnno.r, parambnno.s, parambnno.t, parambnno.jdField_a_of_type_AndroidGraphicsPointF, parambnno.m, 1);
  }
  
  public bnno a()
  {
    return this.jdField_a_of_type_Bnno;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bnno);
    this.jdField_a_of_type_Bnno = null;
    this.jdField_a_of_type_Bnnn.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bnno == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bnno.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bngm parambngm)
  {
    this.jdField_a_of_type_Bngm = parambngm;
  }
  
  public void a(bnno parambnno)
  {
    this.jdField_a_of_type_Bnno = parambnno;
    if (this.jdField_a_of_type_Bnno == null) {}
    do
    {
      return;
      bngn.c(true);
      if ((this.jdField_a_of_type_Bnno instanceof bngq))
      {
        this.jdField_a_of_type_Bnnn.a(6.0F);
        this.jdField_a_of_type_Bnnn.b(0.2F);
        return;
      }
    } while ((!(this.jdField_a_of_type_Bnno instanceof bngd)) && (!(this.jdField_a_of_type_Bnno instanceof bnga)));
    this.jdField_a_of_type_Bnnn.a(18.0F);
    this.jdField_a_of_type_Bnnn.b(0.2F);
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
  
  public void b(bnno parambnno)
  {
    if (parambnno == null) {}
    while ((parambnno.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    xvv.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bnno != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno, f1, f2, true))
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
    b(this.jdField_a_of_type_Bnno);
    this.jdField_a_of_type_Bnno = null;
    bngn.c(false);
    k();
  }
  
  public void c(bnno parambnno)
  {
    if (parambnno == null) {
      return;
    }
    parambnno.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bnno != null) {
      parambnno.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bnno.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambnno instanceof bngd)) && ((((bngd)parambnno).h == 1) || (((bngd)parambnno).h == 3))) {
      ((bngd)parambnno).a.setCallback(this);
    }
    this.jdField_a_of_type_Bnno = parambnno;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.jdField_a_of_type_Bngw != null) {
      this.jdField_a_of_type_Bngw.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label74:
      this.jdField_a_of_type_Bnnn.a(paramMotionEvent, true);
      if (i == 0) {
        d();
      }
      break;
    }
    while ((!(this.jdField_a_of_type_Bnno instanceof bngd)) && (!(this.jdField_a_of_type_Bnno instanceof bngq)))
    {
      return true;
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Bnno != null) {
        this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bnno);
      }
      if (this.jdField_a_of_type_Bnno != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bnno == null) || (this.jdField_a_of_type_Bnno.e != true) || (!this.jdField_a_of_type_Bnno.g) || (this.jdField_a_of_type_Bnno.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bnno.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      xvv.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bnno.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      i = 1;
      break label74;
      if (k > 10) {
        this.jdField_a_of_type_Boolean = true;
      }
      i = 1;
      break label74;
      if (!this.jdField_a_of_type_Boolean) {
        b(paramMotionEvent);
      }
      if (this.jdField_a_of_type_Bnno != null) {
        this.jdField_a_of_type_Bnno.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bnno != null) {
        this.jdField_a_of_type_Bnno.e = false;
      }
      this.jdField_a_of_type_Bnnn.a();
      break label74;
    }
    d(this.jdField_a_of_type_Bnno);
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
 * Qualified Name:     bngl
 * JD-Core Version:    0.7.0.1
 */