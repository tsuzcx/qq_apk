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

public class bowd
  extends bown
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public bowe a;
  public bpdf a;
  public bpdg a;
  public boolean a;
  public bpdg b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bowd.class.getSimpleName();
  }
  
  public bowd(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Bpdf = new bpdf();
    this.jdField_a_of_type_Bpdf.a(true);
    this.jdField_a_of_type_Bpdf.a(6.0F);
    this.jdField_a_of_type_Bpdf.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg, f1, f2)) {
      this.jdField_a_of_type_Bpdg.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bpdf.e(this.jdField_a_of_type_Bpdg, f1, f2))
      {
        this.jdField_a_of_type_Bpdg.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Bpdf.b(this.jdField_a_of_type_Bpdg, f1, f2));
    this.jdField_a_of_type_Bpdg.jdField_k_of_type_Int = 2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg, paramFloat1, paramFloat2, true);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg, f1, f2)) {
      if (this.jdField_a_of_type_Bowe != null)
      {
        if (!(this.jdField_a_of_type_Bpdg instanceof bowi)) {
          break label77;
        }
        paramMotionEvent = ((bowi)this.jdField_a_of_type_Bpdg).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg, paramMotionEvent.b(), 2);
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
              this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg, 0, 0);
              return;
              if (!this.jdField_a_of_type_Bpdf.e(this.jdField_a_of_type_Bpdg, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Bowe == null);
            this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg);
            return;
            if (!this.jdField_a_of_type_Bpdf.b(this.jdField_a_of_type_Bpdg, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Bowe == null);
          this.jdField_a_of_type_Bowe.b(this.jdField_a_of_type_Bpdg);
          return;
          if (!this.jdField_a_of_type_Bpdf.c(this.jdField_a_of_type_Bpdg, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_Bpdg.g) {
            this.jdField_a_of_type_Bpdg.g = true;
          }
        } while (this.jdField_a_of_type_Bowe == null);
        this.jdField_a_of_type_Bowe.b(this.jdField_a_of_type_Bpdg, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg, f1, f2, true)) || (this.jdField_a_of_type_Bowe == null) || (this.jdField_a_of_type_Bpdg == null));
      if (!(this.jdField_a_of_type_Bpdg instanceof bowi)) {
        break;
      }
      localDynamicTextItem = ((bowi)this.jdField_a_of_type_Bpdg).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (bowi)this.jdField_a_of_type_Bpdg, this.jdField_a_of_type_Bpdf);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg, localDynamicTextItem.b(), 0, f1, f2);
    return;
    ykq.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bpdg);
    this.jdField_a_of_type_Bowe.a(this.jdField_a_of_type_Bpdg, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(bpdg parambpdg)
  {
    boolean bool1 = this.jdField_a_of_type_Bpdf.a(parambpdg, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bpdf.a(parambpdg, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bpdf.b(parambpdg, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bowe != null) {
      this.jdField_a_of_type_Bowe.a(bool1, bool2, false, bool3, parambpdg.l);
    }
    if (parambpdg != null)
    {
      if (parambpdg.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambpdg.l, parambpdg.r, parambpdg.s, parambpdg.t, parambpdg.jdField_a_of_type_AndroidGraphicsPointF, parambpdg.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambpdg.l, parambpdg.r, parambpdg.s, parambpdg.t, parambpdg.jdField_a_of_type_AndroidGraphicsPointF, parambpdg.m, 1);
  }
  
  public bpdg a()
  {
    return this.jdField_a_of_type_Bpdg;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_Bpdg);
    this.jdField_a_of_type_Bpdg = null;
    this.jdField_a_of_type_Bpdf.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bpdg == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Bpdg.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(bowe parambowe)
  {
    this.jdField_a_of_type_Bowe = parambowe;
  }
  
  public void a(bpdg parambpdg)
  {
    this.jdField_a_of_type_Bpdg = parambpdg;
    if (this.jdField_a_of_type_Bpdg == null) {}
    do
    {
      return;
      bowf.c(true);
      if ((this.jdField_a_of_type_Bpdg instanceof bowi))
      {
        this.jdField_a_of_type_Bpdf.a(6.0F);
        this.jdField_a_of_type_Bpdf.b(0.2F);
        return;
      }
    } while ((!(this.jdField_a_of_type_Bpdg instanceof bovv)) && (!(this.jdField_a_of_type_Bpdg instanceof bovs)));
    this.jdField_a_of_type_Bpdf.a(18.0F);
    this.jdField_a_of_type_Bpdf.b(0.2F);
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
  
  public void b(bpdg parambpdg)
  {
    if (parambpdg == null) {}
    while ((parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    ykq.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bpdg != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg, f1, f2, true))
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
    b(this.jdField_a_of_type_Bpdg);
    this.jdField_a_of_type_Bpdg = null;
    bowf.c(false);
    k();
  }
  
  public void c(bpdg parambpdg)
  {
    if (parambpdg == null) {
      return;
    }
    parambpdg.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bpdg != null) {
      parambpdg.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_Bpdg.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((parambpdg instanceof bovv)) && ((((bovv)parambpdg).h == 1) || (((bovv)parambpdg).h == 3))) {
      ((bovv)parambpdg).a.setCallback(this);
    }
    this.jdField_a_of_type_Bpdg = parambpdg;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.jdField_a_of_type_Bowo != null) {
      this.jdField_a_of_type_Bowo.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label74:
      this.jdField_a_of_type_Bpdf.a(paramMotionEvent, true);
      if (i == 0) {
        d();
      }
      break;
    }
    while ((!(this.jdField_a_of_type_Bpdg instanceof bovv)) && (!(this.jdField_a_of_type_Bpdg instanceof bowi)))
    {
      return true;
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Bpdg != null) {
        this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bpdg);
      }
      if (this.jdField_a_of_type_Bpdg != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_Bpdg == null) || (this.jdField_a_of_type_Bpdg.e != true) || (!this.jdField_a_of_type_Bpdg.g) || (this.jdField_a_of_type_Bpdg.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_Bpdg.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      ykq.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_Bpdg.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
      if (this.jdField_a_of_type_Bpdg != null) {
        this.jdField_a_of_type_Bpdg.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Bpdg != null) {
        this.jdField_a_of_type_Bpdg.e = false;
      }
      this.jdField_a_of_type_Bpdf.a();
      break label74;
    }
    d(this.jdField_a_of_type_Bpdg);
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
 * Qualified Name:     bowd
 * JD-Core Version:    0.7.0.1
 */